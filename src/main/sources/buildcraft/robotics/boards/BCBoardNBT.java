package buildcraft.robotics.boards;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.IconRegister;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;
import net.minecraft.EnumChatFormatting;
import net.minecraft.Icon;
import net.minecraft.ResourceLocation;

import buildcraft.api.boards.RedstoneBoardRobot;
import buildcraft.api.boards.RedstoneBoardRobotNBT;
import buildcraft.api.robots.EntityRobotBase;
import buildcraft.core.DefaultProps;
import buildcraft.core.lib.utils.StringUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class BCBoardNBT extends RedstoneBoardRobotNBT {

    public static final Map<String, BCBoardNBT> REGISTRY = new HashMap<>();
    private final ResourceLocation texture;
    private final String id, upperName, boardType;
    private final Constructor<? extends RedstoneBoardRobot> boardInit;

    @Environment(EnvType.CLIENT)
    private Icon icon;

    public BCBoardNBT(String id, String name, Class<? extends RedstoneBoardRobot> board, String boardType) {
        this.id = id;
        this.boardType = boardType;
        this.upperName = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.texture = new ResourceLocation(DefaultProps.TEXTURE_PATH_ROBOTS + "/robot_" + name + ".png");

        Constructor<? extends RedstoneBoardRobot> boardInitLocal;
        try {
            boardInitLocal = board.getConstructor(EntityRobotBase.class);
        } catch (Exception e) {
            e.printStackTrace();
            boardInitLocal = null;
        }
        this.boardInit = boardInitLocal;

        REGISTRY.put(name, this);
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        list.add(EnumChatFormatting.BOLD + StringUtils.localize("buildcraft.boardRobot" + upperName));
        list.add(StringUtils.localize("buildcraft.boardRobot" + upperName + ".desc"));
    }

    @Override
    public RedstoneBoardRobot create(EntityRobotBase robot) {
        try {
            return boardInit.newInstance(robot);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icon = iconRegister.registerIcon("buildcraftrobotics:board/" + boardType);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public Icon getIcon(NBTTagCompound nbt) {
        return icon;
    }

    @Override
    public ResourceLocation getRobotTexture() {
        return texture;
    }
}
