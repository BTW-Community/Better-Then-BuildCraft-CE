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
import net.minecraft.src.IconRegister;
import net.minecraft.src.Icon;

public class BlockBuildTool extends Block {

    public BlockBuildTool(int id) {
        super(id, Material.iron);
    }

    @Override
    public void registerIcons(IconRegister itemRegister) {}

    @Override
    public Icon getIcon(int i, int j) {
        return BuildCraftCore.redLaserTexture;
    }
}
