package buildcraft.core.lib.block;

import net.minecraft.ItemStack;
import net.minecraft.TileEntity;

/**
 * Implemented by Blocks which have an inventory Comparator override.
 */
public interface IComparatorInventory {

    boolean doesSlotCountComparator(TileEntity tile, int slot, ItemStack stack);
}
