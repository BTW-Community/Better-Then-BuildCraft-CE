/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.transport;

import java.util.List;

import net.minecraft.IconRegister;
import net.minecraft.CreativeTabs;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Icon;

import buildcraft.api.transport.PipeWire;
import buildcraft.core.lib.items.ItemBuildCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ItemPipeWire extends ItemBuildCraft {

    private Icon[] icons;

    public ItemPipeWire() {
        super();
        setHasSubtypes(true);
        setMaxDamage(0);
        setPassSneakClick(true);
        setUnlocalizedName("pipeWire");
    }

    @Override
    public Icon getIconFromDamage(int damage) {
        return icons[damage % icons.length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + PipeWire.fromOrdinal(stack.getItemDamage()).getTag();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @Environment(EnvType.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        for (PipeWire pipeWire : PipeWire.VALUES) {
            itemList.add(pipeWire.getStack());
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        icons = new Icon[PipeWire.VALUES.length];
        for (PipeWire pipeWire : PipeWire.VALUES) {
            icons[pipeWire.ordinal()] = par1IconRegister
                    .registerIcon("buildcrafttransport:pipeWire/" + pipeWire.getColor().toLowerCase());
        }
    }

    public void registerItemStacks() {
        for (PipeWire pipeWire : PipeWire.VALUES) {
            GameRegistry.registerCustomItemStack(pipeWire.getTag(), pipeWire.getStack());
        }
    }
}
