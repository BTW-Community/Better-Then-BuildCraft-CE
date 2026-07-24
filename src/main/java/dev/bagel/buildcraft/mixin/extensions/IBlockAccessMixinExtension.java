package dev.bagel.buildcraft.mixin.extensions;

import dev.bagel.buildcraft.extensions.IBlockAccessExtension;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(IBlockAccess.class)
public interface IBlockAccessMixinExtension extends IBlockAccessExtension {
    @Shadow int getBlockId(int var1, int var2, int var3);

    @Shadow TileEntity getBlockTileEntity(int var1, int var2, int var3);
    @Override
    default boolean setBlock(int x, int y, int z, Block blockIn, int metadataIn, int flags) {
        return false;
    }

    @Override
    default Block getBlock(int x, int y, int z) {
        return Block.blocksList[getBlockId(x, y, z)];
    }

    @Override
    public default TileEntity getTileEntity(int x, int y, int z) {
        return getBlockTileEntity(x, y, z);
    }
}