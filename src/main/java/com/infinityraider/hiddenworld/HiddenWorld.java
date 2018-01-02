package com.infinityraider.hiddenworld;

import com.infinityraider.hiddenworld.network.MessageSyncAura;
import com.infinityraider.hiddenworld.proxy.IProxy;
import com.infinityraider.hiddenworld.reference.Reference;
import com.infinityraider.hiddenworld.registry.*;
import com.infinityraider.infinitylib.InfinityMod;
import com.infinityraider.infinitylib.network.INetworkWrapper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class HiddenWorld extends InfinityMod {

    @Mod.Instance(Reference.MOD_ID)
    public static HiddenWorld instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Override
    public IProxy proxy() {
        return proxy;
    }

    @Override
    public String getModId() {
        return Reference.MOD_ID;
    }

    @Override
    public Object getModBlockRegistry() {
        return ModBlockRegistry.getInstance();
    }

    @Override
    public Object getModItemRegistry() {
        return ModItemRegistry.getInstance();
    }

    @Override
    public Object getModEntityRegistry() {
        return ModEntityRegistry.getInstance();
    }

    @Override
    public void registerMessages(INetworkWrapper wrapper) {
        wrapper.registerMessage(MessageSyncAura.class);
    }
}
