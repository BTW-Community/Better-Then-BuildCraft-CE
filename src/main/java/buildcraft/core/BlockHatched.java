package buildcraft.core;

import buildcraft.BuildCraftCore;
import buildcraft.api.transport.IPipeTile;
import buildcraft.core.lib.block.BlockBuildCraft;
import buildcraft.core.lib.utils.ResourceUtils;
import buildcraft.core.lib.utils.Utils;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Icon;
import net.minecraft.src.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class BlockHatched extends BlockBuildCraft {

    private Icon itemHatch;

    protected BlockHatched(int id, Material material) {
        super(id, material);

        setRotatable(true);
        setPassCount(2);
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return 1;
    }

    @Override
    public void registerBlockIcons(IconRegister register) {
        super.registerBlockIcons(register);
        String base = ResourceUtils.getObjectPrefix(Block.blockRegistry.getNameForObject(this));
        itemHatch = register.registerIcon(base + "/item_hatch");
    }

    @Override
    public Icon getIconForPass(IBlockAccess access, int x, int y, int z, int side, int pass) {
        // The quarry's pipe connection method has no idea about "sides".
        if (pass == 1) {
            return Utils.isPipeConnected(access, x, y, z, ForgeDirection.getOrientation(side), IPipeTile.PipeType.ITEM)
                    ? itemHatch
                    : BuildCraftCore.transparentTexture;
        }
        return super.getIconForPass(access, x, y, z, side, pass);
    }

    @Override
    public Icon getIconForPass(int side, int meta, int pass) {
        if (pass == 1) {
            return side == 1 ? itemHatch : null;
        }
        return super.getIconForPass(side, meta, pass);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
