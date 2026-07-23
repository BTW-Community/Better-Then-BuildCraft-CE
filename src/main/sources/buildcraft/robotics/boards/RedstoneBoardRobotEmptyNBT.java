package buildcraft.robotics.boards;

import java.util.List;

import net.minecraft.IconRegister;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;
import net.minecraft.Icon;
import net.minecraft.ResourceLocation;

import buildcraft.api.boards.RedstoneBoardRobot;
import buildcraft.api.boards.RedstoneBoardRobotNBT;
import buildcraft.api.robots.EntityRobotBase;
import buildcraft.robotics.EntityRobot;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class RedstoneBoardRobotEmptyNBT extends RedstoneBoardRobotNBT {

    public static RedstoneBoardRobotEmptyNBT instance = new RedstoneBoardRobotEmptyNBT();
    private Icon icon;

    @Override
    public RedstoneBoardRobot create(EntityRobotBase robot) {
        return new BoardRobotEmpty(robot);
    }

    @Override
    public ResourceLocation getRobotTexture() {
        return EntityRobot.ROBOT_BASE;
    }

    @Override
    public String getID() {
        return "buildcraft:boardRobotEmpty";
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<?> list, boolean advanced) {}

    @Override
    @Environment(EnvType.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icon = iconRegister.registerIcon("buildcraftrobotics:board/clean");
    }

    @Override
    @Environment(EnvType.CLIENT)
    public Icon getIcon(NBTTagCompound nbt) {
        return icon;
    }
}
