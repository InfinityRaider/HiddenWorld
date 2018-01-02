package com.infinityraider.hiddenworld.proxy;


import com.infinityraider.hiddenworld.configuration.ConfigurationHandler;
import com.infinityraider.infinitylib.proxy.base.IProxyBase;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy extends IProxyBase {
    @Override
    default void initConfiguration(FMLPreInitializationEvent event) {
        ConfigurationHandler.getInstance().init(event);
    }

    @Override
    default void registerEventHandlers() {

    }

    @Override
    default void activateRequiredModules() {

    }

    @Override
    default void registerCapabilities() {

    }
}
