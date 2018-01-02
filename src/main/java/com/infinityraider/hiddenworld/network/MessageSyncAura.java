package com.infinityraider.hiddenworld.network;

import com.infinityraider.hiddenworld.ghostworld.entity.GhostAura;
import com.infinityraider.infinitylib.network.MessageBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageSyncAura extends MessageBase<IMessage> {
    private EntityPlayer player;
    private NBTTagCompound ghostTag;

    public MessageSyncAura() {
        super();
    }

    public MessageSyncAura(EntityPlayer player) {
        this();
        this.player = player;
        this.ghostTag = GhostAura.getAura(player).map(GhostAura::writeToNBT).orElse(new NBTTagCompound());
    }

    @Override
    public Side getMessageHandlerSide() {
        return Side.CLIENT;
    }

    @Override
    protected void processMessage(MessageContext ctx) {
        if(player != null && ghostTag != null) {
            GhostAura.getAura(player).ifPresent(aura -> aura.readFromNBT(this.ghostTag));
        }
    }

    @Override
    protected IMessage getReply(MessageContext ctx) {
        return null;
    }
}