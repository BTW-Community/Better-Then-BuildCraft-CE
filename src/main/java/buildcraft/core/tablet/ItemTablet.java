package buildcraft.core.tablet;

import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import net.minecraft.World;

import buildcraft.core.lib.items.ItemBuildCraft;
import buildcraft.core.tablet.manager.TabletManagerServer;
import cpw.mods.fml.common.FMLCommonHandler;

public class ItemTablet extends ItemBuildCraft {

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote) {
            FMLCommonHandler.instance().showGuiScreen(new GuiTablet(player));
        } else {
            TabletManagerServer.INSTANCE.get(player);
        }

        return stack;
    }
}
