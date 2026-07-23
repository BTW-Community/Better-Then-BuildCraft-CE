/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 *
 * The BuildCraft API is distributed under the terms of the MIT License. Please check the contents of the license, which
 * should be located as "LICENSE.API" in the BuildCraft source code distribution.
 */
package buildcraft.api.boards;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.src.IIconRegister;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.IIcon;
import net.minecraftforge.common.util.Constants;

import java.util.List;
import java.util.Random;

public abstract class RedstoneBoardNBT<T> {

    private static final Random rand = new Random();

    public abstract String getID();

    public abstract void addInformation(ItemStack stack, EntityPlayer player, List<?> list, boolean advanced);

    public abstract IRedstoneBoard<T> create(NBTTagCompound nbt, T object);

    @SideOnly(Side.CLIENT)
    public abstract void registerIcons(IIconRegister iconRegister);

    @SideOnly(Side.CLIENT)
    public abstract IIcon getIcon(NBTTagCompound nbt);

    public void createBoard(NBTTagCompound nbt) {
        nbt.setString("id", getID());
    }

    public int getParameterNumber(NBTTagCompound nbt) {
        if (!nbt.hasKey("parameters")) {
            return 0;
        } else {
            return nbt.getTagList("parameters", Constants.NBT.TAG_COMPOUND).tagCount();
        }
    }

    public float nextFloat(int difficulty) {
        return 1F - (float) Math.pow(rand.nextFloat(), 1F / difficulty);
    }
}
