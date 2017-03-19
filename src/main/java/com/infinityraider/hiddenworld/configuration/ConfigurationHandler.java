package com.infinityraider.hiddenworld.configuration;

import com.infinityraider.infinitylib.InfinityLib;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConfigurationHandler {
    private static final ConfigurationHandler INSTANCE = new ConfigurationHandler();

    private ConfigurationHandler() {}

    public static ConfigurationHandler getInstance() {
        return INSTANCE;
    }

    private Configuration config;

    //general
    public String[] dimensionwhitelist;
    public String[] mirrorIds;

    //debug
    public boolean debug;

    public void init(FMLPreInitializationEvent event) {
        if(config == null) {
            config = new Configuration(event.getSuggestedConfigurationFile());
        }
        loadConfiguration();
        if(config.hasChanged()) {
            config.save();
        }
        InfinityLib.instance.getLogger().debug("Configuration Loaded");
    }

    @SideOnly(Side.CLIENT)
    public void initClientConfigs(FMLPreInitializationEvent event) {
        if(config == null) {
            config = new Configuration(event.getSuggestedConfigurationFile());
        }
        loadClientConfiguration(event);
        if(config.hasChanged()) {
            config.save();
        }
        InfinityLib.instance.getLogger().debug("Client configuration Loaded");
    }

    private void loadConfiguration() {
        //general
        dimensionwhitelist = config.getStringList("dimension white list", Categories.GENERAL.getName(), new String[]{"0", "-1"},
                "The white list for dimensions which are allowed to be mirrored");

        mirrorIds = config.getStringList("mirror dimension id's", Categories.GENERAL.getName(), new String[]{"-50", "-51"},
                "The dimension ids for the mirror dimensions, has to be the same length as the dimension white list");

        //debug
        debug = config.getBoolean("debug", com.infinityraider.infinitylib.handler.ConfigurationHandler.Categories.DEBUG.getName(), false, "Set to true if you wish to enable debug mode");
    }

    @SideOnly(Side.CLIENT)
    private void loadClientConfiguration(FMLPreInitializationEvent event) {

    }

    public enum Categories {
        GENERAL("general"),
        DEBUG("debug");

        private final String name;

        Categories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
