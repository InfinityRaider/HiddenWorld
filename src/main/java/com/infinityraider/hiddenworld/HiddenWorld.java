package com.infinityraider.hiddenworld;

import com.infinityraider.hiddenworld.reference.Reference;
import com.infinityraider.hiddenworld.registry.ModBlockRegistry;
import com.infinityraider.hiddenworld.registry.ModEntityRegistry;
import com.infinityraider.hiddenworld.registry.ModItemRegistry;
import com.infinityraider.infinitylib.InfinityLib;
import com.infinityraider.infinitylib.InfinityMod;
import com.infinityraider.infinitylib.network.INetworkWrapper;
import com.infinityraider.infinitylib.proxy.IProxy;
import com.infinityraider.infinitylib.proxy.base.IProxyBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class HiddenWorld extends InfinityMod {

    @Mod.Instance(com.infinityraider.infinitylib.reference.Reference.MOD_ID)
    public static InfinityLib instance;

    @SidedProxy(clientSide = com.infinityraider.infinitylib.reference.Reference.CLIENT_PROXY_CLASS, serverSide = com.infinityraider.infinitylib.reference.Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Override
    public IProxyBase proxy() {
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

    }
}
