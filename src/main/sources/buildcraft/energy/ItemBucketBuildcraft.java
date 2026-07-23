/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.energy;

import net.minecraft.Block;
import net.minecraft.IIconRegister;
import net.minecraft.CreativeTabs;
import net.minecraft.Items;
import net.minecraft.Item;
import net.minecraft.ItemBucket;

import buildcraft.core.BCCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBucketBuildcraft extends ItemBucket {

    private String iconName;

    public ItemBucketBuildcraft(Block block) {
        this(block, BCCreativeTab.get("main"));
    }

    public ItemBucketBuildcraft(Block block, CreativeTabs creativeTab) {
        super(block);
        setContainerItem(Items.bucket);
        setCreativeTab(creativeTab);
    }

    @Override
    public Item setUnlocalizedName(String par1Str) {
        iconName = par1Str;
        return super.setUnlocalizedName(par1Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("buildcraftenergy:" + iconName);
    }
}
