/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.transport.gates;

import java.util.Locale;

import net.minecraft.IconRegister;
import net.minecraft.Icon;
import net.minecraft.ResourceLocation;

import buildcraft.core.lib.utils.StringUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public final class GateDefinition {

    private GateDefinition() {}

    public static String getLocalizedName(GateMaterial material, GateLogic logic) {
        if (material == GateMaterial.REDSTONE) {
            return StringUtils.localize("gate.name.basic");
        } else {
            return String.format(
                    StringUtils.localize("gate.name"),
                    StringUtils.localize("gate.material." + material.getTag()),
                    StringUtils.localize("gate.logic." + logic.getTag()));
        }
    }

    public enum GateMaterial {

        REDSTONE("gate_interface_1.png", 146, 1, 0, 0, 1),
        IRON("gate_interface_2.png", 164, 2, 0, 0, 2),
        GOLD("gate_interface_3.png", 200, 4, 1, 0, 3),
        DIAMOND("gate_interface_4.png", 200, 8, 1, 0, 4),
        EMERALD("gate_interface_5.png", 200, 4, 3, 3, 4),
        QUARTZ("gate_interface_6.png", 164, 2, 1, 1, 3);

        public static final GateMaterial[] VALUES = values();
        public final ResourceLocation guiFile;
        public final int guiHeight;
        public final int numSlots;
        public final int numTriggerParameters;
        public final int numActionParameters;
        public final int maxWireColor;

        @Environment(EnvType.CLIENT)
        private Icon iconBlock;

        @Environment(EnvType.CLIENT)
        private Icon iconItem;

        GateMaterial(String guiFile, int guiHeight, int numSlots, int triggerParameterSlots, int actionParameterSlots,
                int maxWireColor) {
            this.guiFile = new ResourceLocation("buildcrafttransport:textures/gui/" + guiFile);
            this.guiHeight = guiHeight;
            this.numSlots = numSlots;
            this.numTriggerParameters = triggerParameterSlots;
            this.numActionParameters = actionParameterSlots;
            this.maxWireColor = maxWireColor;
        }

        @Environment(EnvType.CLIENT)
        public Icon getIconBlock() {
            return iconBlock;
        }

        @Environment(EnvType.CLIENT)
        public Icon getIconItem() {
            return iconItem;
        }

        public String getTag() {
            return name().toLowerCase(Locale.ENGLISH);
        }

        @Environment(EnvType.CLIENT)
        public void registerBlockIcon(IconRegister iconRegister) {
            if (this != REDSTONE) {
                iconBlock = iconRegister.registerIcon("buildcrafttransport:gates/gate_material_" + getTag());
            }
        }

        @Environment(EnvType.CLIENT)
        public void registerItemIcon(IconRegister iconRegister) {
            if (this != REDSTONE) {
                iconItem = iconRegister.registerIcon("buildcrafttransport:gates/gate_material_" + getTag());
            }
        }

        public static GateMaterial fromOrdinal(int ordinal) {
            if (ordinal < 0 || ordinal >= VALUES.length) {
                return REDSTONE;
            }
            return VALUES[ordinal];
        }
    }

    public enum GateLogic {

        AND,
        OR;

        public static final GateLogic[] VALUES = values();

        @Environment(EnvType.CLIENT)
        private Icon iconLit;

        @Environment(EnvType.CLIENT)
        private Icon iconDark;

        @Environment(EnvType.CLIENT)
        private Icon iconItem;

        @Environment(EnvType.CLIENT)
        private Icon iconGate;

        @Environment(EnvType.CLIENT)
        public Icon getIconLit() {
            return iconLit;
        }

        @Environment(EnvType.CLIENT)
        public Icon getIconDark() {
            return iconDark;
        }

        @Environment(EnvType.CLIENT)
        public Icon getGateIcon() {
            return iconGate;
        }

        @Environment(EnvType.CLIENT)
        public Icon getIconItem() {
            return iconItem;
        }

        public String getTag() {
            return name().toLowerCase(Locale.ENGLISH);
        }

        @Environment(EnvType.CLIENT)
        public void registerBlockIcon(IconRegister iconRegister) {
            iconLit = iconRegister.registerIcon("buildcrafttransport:gates/gate_" + getTag() + "_lit");
            iconDark = iconRegister.registerIcon("buildcrafttransport:gates/gate_" + getTag() + "_dark");

            iconGate = iconRegister.registerIcon("buildcrafttransport:gates/gate_" + getTag());
        }

        @Environment(EnvType.CLIENT)
        public void registerItemIcon(IconRegister iconRegister) {
            iconItem = iconRegister.registerIcon("buildcrafttransport:gates/gate_logic_" + getTag());
        }

        public static GateLogic fromOrdinal(int ordinal) {
            if (ordinal < 0 || ordinal >= VALUES.length) {
                return AND;
            }
            return VALUES[ordinal];
        }
    }
}
