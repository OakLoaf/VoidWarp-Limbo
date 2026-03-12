package org.lushplugins.voidwarplimbo.util;

import java.util.Map;

public class ConfigurationMap {
    private final Map<String, Object> map;

    public ConfigurationMap(Map<String, Object> map) {
        this.map = map;
    }

    public <T> T get(String path) {
        return (T) map.get(path);
    }

    public String getString(String path, String def) {
        String string = get(path);
        return string != null ? string : def;
    }

    public double getDouble(String path, double def) {
        Number number = get(path);
        return number != null ? number.doubleValue() : def;
    }

    public Map<String, Object> asMap() {
        return map;
    }
}
