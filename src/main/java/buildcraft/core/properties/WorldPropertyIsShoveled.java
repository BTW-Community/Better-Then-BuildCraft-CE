/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.core.properties;

import net.minecraft.Block;
import net.minecraft.BlockClay;
import net.minecraft.BlockDirt;
import net.minecraft.BlockFarmland;
import net.minecraft.BlockGrass;
import net.minecraft.BlockGravel;
import net.minecraft.BlockSand;
import net.minecraft.BlockSnow;
import net.minecraft.IBlockAccess;

public class WorldPropertyIsShoveled extends WorldProperty {

    @Override
    public boolean get(IBlockAccess blockAccess, Block block, int meta, int x, int y, int z) {
        return block instanceof BlockDirt || block instanceof BlockSand
                || block instanceof BlockClay
                || block instanceof BlockGravel
                || block instanceof BlockFarmland
                || block instanceof BlockGrass
                || block instanceof BlockSnow;
    }
}
