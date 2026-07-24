package dev.bagel.buildcraft.mixin.extensions;

import dev.bagel.buildcraft.extensions.NBTTagListExtension;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(NBTTagList.class)
public abstract class NBTTagListMixinExtension implements NBTTagListExtension {
    @Shadow
    private List tagList;

    @Shadow
    private byte tagType;

    /**
     * Retrieves the NBTTagCompound at the specified index in the list
     */
    public NBTTagCompound getCompoundTagAt(int i) {
        if (i >= 0 && i < this.tagList.size()) {
            NBTBase nbtbase = (NBTBase) this.tagList.get(i);
            return nbtbase.getId() == 10 ? (NBTTagCompound) nbtbase : new NBTTagCompound();
        } else {
            return new NBTTagCompound();
        }
    }

    public int[] func_150306_c(int i) {
        if (i >= 0 && i < this.tagList.size()) {
            NBTBase nbtbase = (NBTBase) this.tagList.get(i);
            return nbtbase.getId() == 11 ? ((NBTTagIntArray) nbtbase).intArray : new int[0];
        } else {
            return new int[0];
        }
    }

    public double func_150309_d(int i) {
        if (i >= 0 && i < this.tagList.size()) {
            NBTBase nbtbase = (NBTBase) this.tagList.get(i);
            return nbtbase.getId() == 6 ? ((NBTTagDouble) nbtbase).data : 0.0D;
        } else {
            return 0.0D;
        }
    }

    public float func_150308_e(int i) {
        if (i >= 0 && i < this.tagList.size()) {
            NBTBase nbtbase = (NBTBase) this.tagList.get(i);
            return nbtbase.getId() == 5 ? ((NBTTagFloat) nbtbase).data : 0.0F;
        } else {
            return 0.0F;
        }
    }

    /**
     * Retrieves the tag String value at the specified index in the list
     */
    public String getStringTagAt(int i) {
        if (i >= 0 && i < this.tagList.size()) {
            NBTBase nbtbase = (NBTBase) this.tagList.get(i);
            return nbtbase.getId() == 8 ? nbtbase.toString() : nbtbase.toString();
        } else {
            return "";
        }
    }

    @Override
    public int func_150303_d() {
        return tagType;
    }
}
