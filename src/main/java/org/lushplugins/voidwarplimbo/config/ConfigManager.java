package org.lushplugins.voidwarplimbo.config;

import com.loohp.limbo.location.Location;
import org.lushplugins.voidwarplimbo.VoidWarpLimbo;
import org.lushplugins.voidwarplimbo.util.ConfigurationMap;
import org.lushplugins.voidwarplimbo.util.YamlConfiguration;

public class ConfigManager {
    private Location spawnLocation;
    private double minY;
    private double maxY;
    private String message;

    public ConfigManager() {
        YamlConfiguration.saveDefaultConfig();
    }
    public void reload() {

        this.spawnLocation = VoidWarpLimbo.getInstance().getServer().getServerProperties().getWorldSpawn();

        ConfigurationMap config = YamlConfiguration.loadConfig();
        this.minY = config.getDouble("yMin", Double.MIN_VALUE);
        this.maxY = config.getDouble("yMax", Double.MAX_VALUE);
        this.message = config.getString("message", "&7Teleported to &e%location%&7.");
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public String getMessage() {
        return message;
    }
}
