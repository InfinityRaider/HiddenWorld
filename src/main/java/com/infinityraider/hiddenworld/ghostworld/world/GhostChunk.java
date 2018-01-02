package com.infinityraider.hiddenworld.ghostworld.world;

import com.infinityraider.infinitylib.utility.ISerializable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;

import java.util.Optional;

public class GhostChunk extends Chunk implements ISerializable {
    private final Chunk carrier;

    public GhostChunk(Chunk carrier) {
        super(carrier.getWorld(), carrier.x, carrier.z);
        this.carrier = carrier;
    }

    /**
     * -------------
     * CHUNK METHODS
     * -------------
     */


    /**
     * ------------------
     * CAPABILITY METHODS
     * ------------------
     */

    /**
     * Reads the chunk data from NBT
     */
    @Override
    public void readFromNBT(NBTTagCompound tag) {

    }

    /**
     * Writes the chunk data from NBT
     */

    @Override
    public NBTTagCompound writeToNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        return tag;
    }

    /**
     * Utility method to retrieve ghost chunk data from a chunk
     */
    public static Optional<GhostChunk> get(Chunk chunk) {
        return Optional.ofNullable(chunk.getCapability(CapabilityGhostChunk.CAPABILITY_GHOST_CHUNK, null));
    }
}