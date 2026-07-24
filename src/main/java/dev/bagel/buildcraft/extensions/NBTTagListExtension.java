package dev.bagel.buildcraft.extensions;

import net.minecraft.src.NBTTagCompound;

public interface NBTTagListExtension {
    /**
     * Retrieves the NBTTagCompound at the specified index in the list
     */
    default public NBTTagCompound getCompoundTagAt(int idx) {
        throw new UnsupportedOperationException("this should be overridden by mixin. wtf?");
    }

    default int[] func_150306_c(int idx)
    {
        throw new UnsupportedOperationException("this should be overridden by mixin. wtf?");
    }

    default double func_150309_d(int idx)
    {
        throw new UnsupportedOperationException("this should be overridden by mixin. wtf?");
    }

    default float func_150308_e(int idx) {
        throw new UnsupportedOperationException("this should be overridden by mixin. wtf?");
    }

    /**
     * Retrieves the tag String value at the specified index in the list
     */
    default String getStringTagAt(int idx) {
        throw new UnsupportedOperationException("this should be overridden by mixin. wtf?");
    }

    /**
     * Retrieves the tag type of the list
     * */
    default int func_150303_d()
    {
        throw new UnsupportedOperationException("this should be overridden by mixin. wtf?");
    }
}
