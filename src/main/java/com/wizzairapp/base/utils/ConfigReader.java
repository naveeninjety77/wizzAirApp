package com.wizzairapp.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Simple config reader that prefers system properties and falls back to
 * values in src/test/resources/config.properties.
 */
public final class ConfigReader {
    private static final String CONFIG_PATH = "/config.properties";
    private static final ConfigReader INSTANCE = new ConfigReader();
    private final Properties props = new Properties();

    private ConfigReader() {
        // load defaults from resources if available
        try (InputStream in = getClass().getResourceAsStream(CONFIG_PATH)) {
            if (in != null) props.load(in);
        } catch (IOException ignored) {
        }
    }

    public static ConfigReader getInstance() {
        return INSTANCE;
    }

    /**
     * Returns the value for the key. System property overrides resource property.
     */
    public String get(String key, String defaultValue) {
        String sys = System.getProperty(key);
        if (sys != null && !sys.isEmpty()) return sys;
        String p = props.getProperty(key);
        return p != null ? p : defaultValue;
    }
}
