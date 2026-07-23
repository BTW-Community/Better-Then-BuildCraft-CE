package buildcraft.api.robots;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.src.TextureManager;
import net.minecraft.src.ItemStack;

public interface IRobotOverlayItem {

    boolean isValidRobotOverlay(ItemStack stack);

    @SideOnly(Side.CLIENT)
    void renderRobotOverlay(ItemStack stack, TextureManager textureManager);
}
