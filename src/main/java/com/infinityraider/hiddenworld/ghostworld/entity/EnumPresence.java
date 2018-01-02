package com.infinityraider.hiddenworld.ghostworld.entity;

import com.infinityraider.hiddenworld.HiddenWorld;
import net.minecraft.nbt.NBTTagCompound;

public enum EnumPresence {
    NONE(false, RenderType.NONE, false, false),
    WEAK(true, RenderType.HALF, false, false),
    STRONG(true, RenderType.FULL, true, false),
    FULL(true, RenderType.FULL, true, true);

    private static final String KEY = HiddenWorld.instance.getModId() + ":presence";

    private final boolean target;
    private final RenderType render;
    private final boolean attack;
    private final boolean interact;

    EnumPresence(boolean target, RenderType render, boolean attack, boolean interact) {
        this.target = target;
        this.render = render;
        this.attack = attack;
        this.interact = interact;
    }

    public boolean isTarget() {
        return target;
    }

    public boolean renderHalf() {
        return render == RenderType.HALF;
    }

    public boolean renderFull() {
        return render == RenderType.FULL;
    }

    public boolean canAttack() {
        return attack;
    }

    public boolean canInteract() {
        return interact;
    }

    public NBTTagCompound toNBT(NBTTagCompound tag) {
        tag.setInteger(KEY, this.ordinal());
        return tag;
    }

    public static EnumPresence fromNBT(NBTTagCompound tag) {
        if(! tag.hasKey(KEY)) {
            return NONE;
        }
        int index = tag.getInteger(KEY);
        if(index >= 0 && index < values().length) {
            return values()[index];
        }
        return NONE;
    }

    private enum RenderType {
        NONE,
        HALF,
        FULL
    }
}