package com.wizzairapp.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Setup ConfigReader.
 */
public class ConfigReader {

    private final Properties props = new Properties();

    public ConfigReader(String env) {
        loadEnvironmentConfig(env);
    }

    private void loadEnvironmentConfig(String env) {
        String configPath = "/config-" + env + ".properties";

        try (InputStream in = getClass().getResourceAsStream(configPath)) {
            if (in != null) {
                props.load(in);
            } else {
                throw new RuntimeException("Configuration file not found: " + configPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + configPath, e);
        }
    }

    /**
     * Get property with priority:
     * System property > config file > default
     */
    public String get(String key, String defaultValue) {

        String sys = System.getProperty(key);
        if (sys != null && !sys.isEmpty()) {
            return sys;
        }

        String value = props.getProperty(key);
        return value != null ? value : defaultValue;
    }

    /**
     * Runtime override support (used when XML passes deviceName etc.)
     */
    public void set(String key, String value) {
        props.setProperty(key, value);
    }
}