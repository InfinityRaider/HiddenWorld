package com.infinityraider.hiddenworld.ghostworld.entity;

import com.infinityraider.hiddenworld.HiddenWorld;
import com.infinityraider.infinitylib.capability.ICapabilityImplementation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityGhostAura implements ICapabilityImplementation<EntityPlayer, GhostAura> {
    private static final CapabilityGhostAura INSTANCE = new CapabilityGhostAura();

    public static CapabilityGhostAura getInstance() {
        return INSTANCE;
    }

    public static final ResourceLocation KEY = new ResourceLocation(HiddenWorld.instance.getModId());
    
    @CapabilityInject(GhostAura.class)
    public static Capability<GhostAura> CAPABILITY_GHOST_AURA;

    private CapabilityGhostAura() {}

    @Override
    public Capability<GhostAura> getCapability() {
        return CAPABILITY_GHOST_AURA;
    }

    @Override
    public boolean shouldApplyCapability(EntityPlayer carrier) {
        return true;
    }

    @Override
    public GhostAura createNewValue(EntityPlayer carrier) {
        return new GhostAura(carrier);
    }

    @Override
    public ResourceLocation getCapabilityKey() {
        return KEY;
    }

    @Override
    public Class<EntityPlayer> getCarrierClass() {
        return EntityPlayer.class;
    }

    @Override
    public Class<GhostAura> getCapabilityClass() {
        return GhostAura.class;
    }
}