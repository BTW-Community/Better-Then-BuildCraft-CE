/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.robotics;

import net.minecraft.IconRegister;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import net.minecraft.World;
import net.minecraftforge.common.util.ForgeDirection;

import buildcraft.api.transport.IPipe;
import buildcraft.api.transport.pluggable.IPipePluggableItem;
import buildcraft.api.transport.pluggable.PipePluggable;
import buildcraft.core.BCCreativeTab;
import buildcraft.core.lib.items.ItemBuildCraft;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ItemRobotStation extends ItemBuildCraft implements IPipePluggableItem {

    public ItemRobotStation() {
        super(BCCreativeTab.get("boards"));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return "item.PipeRobotStation";
    }

    @Override
    public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player) {
        return true;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        // NOOP
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getSpriteNumber() {
        return 0;
    }

    @Override
    public PipePluggable createPipePluggable(IPipe pipe, ForgeDirection side, ItemStack stack) {
        return new RobotStationPluggable();
    }
}
