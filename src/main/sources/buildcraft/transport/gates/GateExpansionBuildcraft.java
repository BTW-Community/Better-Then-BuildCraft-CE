/**
 * Copyright (c) 2011-2017, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.transport.gates;

import net.minecraft.IconRegister;
import net.minecraft.Icon;

import buildcraft.api.gates.IGateExpansion;
import buildcraft.core.lib.utils.StringUtils;

public abstract class GateExpansionBuildcraft implements IGateExpansion {

    private final String tag;
    private Icon iconBlock;
    private Icon iconItem;

    public GateExpansionBuildcraft(String tag) {
        this.tag = tag;
    }

    @Override
    public String getUniqueIdentifier() {
        return "buildcraft:" + tag;
    }

    @Override
    public String getDisplayName() {
        return StringUtils.localize("gate.expansion." + tag);
    }

    @Override
    public void registerBlockOverlay(IconRegister iconRegister) {
        iconBlock = iconRegister.registerIcon("buildcrafttransport:gates/gate_expansion_" + tag);
    }

    @Override
    public void registerItemOverlay(IconRegister iconRegister) {
        iconItem = iconRegister.registerIcon("buildcrafttransport:gates/gate_expansion_" + tag);
    }

    @Override
    public Icon getOverlayBlock() {
        return iconBlock;
    }

    @Override
    public Icon getOverlayItem() {
        return iconItem;
    }
}
