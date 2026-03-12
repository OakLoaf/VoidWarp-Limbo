package org.lushplugins.voidwarplimbo;

import com.loohp.limbo.plugins.LimboPlugin;
import org.lushplugins.voidwarplimbo.config.ConfigManager;
import org.lushplugins.voidwarplimbo.listener.PlayerListener;

public final class VoidWarpLimbo extends LimboPlugin {
    private static VoidWarpLimbo plugin;

    public ConfigManager configManager;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager();
        this.configManager.reload();

        getServer().getEventsManager().registerEvents(this, new PlayerListener());
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public static VoidWarpLimbo getInstance() {
        return plugin;
    }
}
