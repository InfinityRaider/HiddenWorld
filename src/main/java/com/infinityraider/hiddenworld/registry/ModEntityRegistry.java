package com.infinityraider.hiddenworld.registry;

public class ModEntityRegistry {
    private static final ModEntityRegistry INSTANCE = new ModEntityRegistry();

    public static ModEntityRegistry getInstance() {
        return INSTANCE;
    }

    private ModEntityRegistry() {}


}
