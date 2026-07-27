/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.core;

import buildcraft.BuildCraftCore;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.IIconRegister;
import net.minecraft.src.IIcon;

public class BlockBuildTool extends Block {

    public BlockBuildTool() {
        super(Material.iron);
    }

    @Override
    public void registerBlockIcons(IIconRegister itemRegister) {}

    @Override
    public IIcon getIcon(int i, int j) {
        return BuildCraftCore.redLaserTexture;
    }
}
