/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.transport.pipes;

import net.minecraft.Item;
import net.minecraft.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import buildcraft.BuildCraftTransport;
import buildcraft.api.core.IconProvider;
import buildcraft.api.transport.IPipeTile;
import buildcraft.transport.IPipeConnectionForced;
import buildcraft.transport.Pipe;
import buildcraft.transport.PipeIconProvider;
import buildcraft.transport.PipeTransportItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class PipeItemsSandstone extends Pipe<PipeTransportItems> implements IPipeConnectionForced {

    public PipeItemsSandstone(Item item) {
        super(new PipeTransportItems(), item);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public IconProvider getIconProvider() {
        return BuildCraftTransport.instance.pipeIconProvider;
    }

    @Override
    public int getIconIndex(ForgeDirection direction) {
        return PipeIconProvider.TYPE.PipeItemsSandstone.ordinal();
    }

    @Override
    public boolean canPipeConnect(TileEntity tile, ForgeDirection side) {
        return (tile instanceof IPipeTile) && super.canPipeConnect(tile, side);
    }

    @Override
    public boolean ignoreConnectionOverrides(ForgeDirection with) {
        return true;
    }
}
