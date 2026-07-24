package dev.bagel.buildcraft.mixin.extensions;

import dev.bagel.buildcraft.extensions.NBTTagCompoundExtension;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.Set;

@Mixin(NBTTagCompound.class)
public abstract class NBTTagCompoundMixinExtension implements NBTTagCompoundExtension {
    @Shadow
    private Map tagMap;

    @Shadow
    protected abstract CrashReport createCrashReport(String string, int i, ClassCastException classCastException);

    @Override
    public Set<String> func_150296_c() {
        return this.tagMap.keySet();
    }

    @Override
    public NBTTagList getTagList(String key, int type) {
        try {
            if (this.func_150299_b(key) != 9) {
                return new NBTTagList();
            } else {
                NBTTagList nbttaglist = (NBTTagList) this.tagMap.get(key);
                return nbttaglist.tagCount() > 0 && nbttaglist.func_150303_d() != type ? new NBTTagList() : nbttaglist;
            }
        } catch (ClassCastException classcastexception) {
            throw new ReportedException(this.createCrashReport(key, 9, classcastexception));
        }
    }

    public byte func_150299_b(String key) {
        NBTBase nbtbase = (NBTBase) this.tagMap.get(key);
        return nbtbase != null ? nbtbase.getId() : 0;
    }
}
