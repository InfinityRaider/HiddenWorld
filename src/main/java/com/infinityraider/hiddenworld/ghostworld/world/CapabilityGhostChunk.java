package com.infinityraider.hiddenworld.ghostworld.world;

import com.infinityraider.hiddenworld.HiddenWorld;
import com.infinityraider.infinitylib.capability.ICapabilityImplementation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityGhostChunk implements ICapabilityImplementation<Chunk, GhostChunk> {
    private static final CapabilityGhostChunk INSTANCE = new CapabilityGhostChunk();

    public static CapabilityGhostChunk getInstance() {
        return INSTANCE;
    }

    public static final ResourceLocation KEY = new ResourceLocation(HiddenWorld.instance.getModId(), "ghost_chunk");

    @CapabilityInject(GhostChunk.class)
    public static Capability<GhostChunk> CAPABILITY_GHOST_CHUNK = null;

    private CapabilityGhostChunk() {}

    @Override
    public Capability<GhostChunk> getCapability() {
        return CAPABILITY_GHOST_CHUNK;
    }

    @Override
    public boolean shouldApplyCapability(Chunk carrier) {
        return !(carrier instanceof GhostChunk);
    }

    @Override
    public GhostChunk createNewValue(Chunk carrier) {
        return new GhostChunk(carrier);
    }

    @Override
    public ResourceLocation getCapabilityKey() {
        return KEY;
    }

    @Override
    public Class<Chunk> getCarrierClass() {
        return Chunk.class;
    }

    @Override
    public Class<GhostChunk> getCapabilityClass() {
        return GhostChunk.class;
    }
}