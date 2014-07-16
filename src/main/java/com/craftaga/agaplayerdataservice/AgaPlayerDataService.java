package com.craftaga.agaplayerdataservice;

import com.craftaga.agabacbone.concurrent.IPluginManager;
import com.craftaga.agabacbone.concurrent.PluginManager;
import com.craftaga.agabacbone.concurrent.schedule.GlobalScheduledTimerHandle;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description
 *
 * @author Jonathan
 * @since 15/07/2014
 */
public class AgaPlayerDataService extends JavaPlugin {
    IPluginManager pluginManager;
    private ClassPathXmlApplicationContext stringContext;

    @Override
    public void onEnable() {
        super.onEnable();
        ClassLoader cl = this.getClass().getClassLoader();
        stringContext = new ClassPathXmlApplicationContext(new String[]{"i18n/messageContext.xml"}, false);
        stringContext.setClassLoader(cl);
        stringContext.refresh();

        pluginManager = PluginManager.getInstance();
        pluginManager.scheduleTimerHandlerAtFixedRate(new GlobalScheduledTimerHandle());
        this.getLogger().info("AgaPlayerDataService Enabled");
    }
}
