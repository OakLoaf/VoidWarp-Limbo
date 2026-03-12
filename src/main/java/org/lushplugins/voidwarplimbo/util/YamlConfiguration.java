package org.lushplugins.voidwarplimbo.util;

import org.lushplugins.voidwarplimbo.VoidWarpLimbo;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class YamlConfiguration {

    public static ConfigurationMap loadConfig() {
        InputStream configStream = null;
        try {
            configStream = Files.newInputStream(VoidWarpLimbo.getInstance().getDataFolder().toPath().resolve("config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ConfigurationMap(new Yaml().load(configStream));
    }

    public static void saveDefaultConfig() {
        Path configPath = VoidWarpLimbo.getInstance().getDataFolder().toPath().resolve("config.yml");
        if (!Files.exists(configPath)) {
            ClassLoader loader = YamlConfiguration.class.getClassLoader();
            InputStream defaultConfig = loader.getResourceAsStream("config.yml");

            if (defaultConfig != null) {
                try {
                    VoidWarpLimbo.getInstance().getDataFolder().mkdirs();
                    Files.copy(defaultConfig, configPath);
                } catch (IOException err) {
                    throw new RuntimeException(err);
                }
            }
        }
    }
}
