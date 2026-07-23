package buildcraft.api.items;

import net.minecraft.ItemStack;

public interface INamedItem {

    String getName(ItemStack stack);

    boolean setName(ItemStack stack, String name);
}
