package buildcraft.core.lib.gui;

import net.minecraft.EntityPlayer;
import net.minecraft.Container;
import net.minecraft.IInventory;

public class ContainerDummy extends Container {

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return false;
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {}
}
