package com.infinityraider.hiddenworld.registry;

import com.infinityraider.hiddenworld.item.ItemDebugger;
import net.minecraft.item.Item;

public class ModItemRegistry {
    private static final ModItemRegistry INSTANCE = new ModItemRegistry();

    public static ModItemRegistry getInstance() {
        return INSTANCE;
    }

    private ModItemRegistry() {
        this.itemDebugger = new ItemDebugger();
    }

    public final Item itemDebugger;
}
