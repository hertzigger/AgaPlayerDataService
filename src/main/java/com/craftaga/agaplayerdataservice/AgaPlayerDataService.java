package com.craftaga.agaplayerdataservice;

import com.craftaga.agabacbone.concurrent.IPluginManager;
import com.craftaga.agabacbone.concurrent.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * description
 *
 * @author Jonathan
 * @since 15/07/2014
 */
public class AgaPlayerDataService extends JavaPlugin {
    IPluginManager pluginManager;

    @Override
    public void onEnable() {
        super.onEnable();
        pluginManager = PluginManager.getInstance();
        this.getLogger().info("AgaPlayerDataService Enabled");
    }
}
