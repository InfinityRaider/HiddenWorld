package com.infinityraider.hiddenworld.ghostworld.entity;

import com.infinityraider.hiddenworld.network.MessageSyncAura;
import com.infinityraider.infinitylib.utility.ISerializable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Optional;

public class GhostAura implements ISerializable {
    private final EntityPlayer player;

    private EnumPresence presence;

    protected GhostAura(EntityPlayer player) {
        this.player = player;
        this.presence = EnumPresence.NONE;
    }

    public GhostAura setPresence(EnumPresence presence) {
        if(!player.getEntityWorld().isRemote && presence != this.getPresence()) {
            this.presence = presence;
            this.syncToClient();
        }
        return this;
    }

    public EnumPresence getPresence() {
        return this.presence;
    }

    public boolean isTarget(EntityLivingBase attacker) {
        return this.getPresence().isTarget();
    }

    public boolean renderHalf() {
        return this.getPresence().renderHalf();
    }

    public boolean renderFull() {
        return this.getPresence().renderFull();
    }

    public boolean canAttack(EntityLivingBase target) {
        return this.getPresence().canAttack();
    }

    public boolean canInteract() {
        return this.getPresence().canInteract();
    }

    protected void syncToClient() {
        if(!this.player.getEntityWorld().isRemote) {
            new MessageSyncAura(player).sendToAll();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        this.presence = EnumPresence.fromNBT(tag);
    }

    @Override
    public NBTTagCompound writeToNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        this.presence.toNBT(tag);
        return tag;
    }

    public static Optional<GhostAura> getAura(EntityPlayer player) {
        return Optional.ofNullable(player.getCapability(CapabilityGhostAura.CAPABILITY_GHOST_AURA, null));
    }
}