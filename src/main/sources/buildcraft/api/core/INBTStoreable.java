package buildcraft.api.core;

import net.minecraft.NBTTagCompound;

public interface INBTStoreable {

    void readFromNBT(NBTTagCompound tag);

    void writeToNBT(NBTTagCompound tag);
}
