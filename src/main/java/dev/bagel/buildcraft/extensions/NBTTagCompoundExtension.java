package dev.bagel.buildcraft.extensions;

import net.minecraft.src.NBTTagList;

import java.util.Set;

public interface NBTTagCompoundExtension {
    default Set<String> func_150296_c() {
        throw new UnsupportedOperationException("This should be overridden by mixin. wtf?");
    }

    default NBTTagList getTagList(String key, int type) {
        throw new UnsupportedOperationException("This should be overridden by mixin. wtf?");
    }
}
