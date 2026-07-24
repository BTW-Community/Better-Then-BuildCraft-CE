package dev.bagel.buildcraft.extensions;

import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

import java.util.ArrayList;

public interface BlockExtension {

    default ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        throw new UnsupportedOperationException("This should be overridden by mixin. wtf?");
    }

    static int getIdFromBlock(Block block) {
        if (block == null) {
            return 0;
        }
        return block.blockID;
    }

    default boolean isAir(World world, int x, int y, int z) {
        throw new UnsupportedOperationException("This should be overridden by mixin. wtf?");
    }

    default ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        throw new UnsupportedOperationException("This should be overridden by mixin. wtf?");
    }

    default boolean hasTileEntity(int meta) {
        throw new UnsupportedOperationException("This should be overridden by mixin. wtf?");
    }
}
