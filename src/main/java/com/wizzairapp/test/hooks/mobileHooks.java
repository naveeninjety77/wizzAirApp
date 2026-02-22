package com.wizzairapp.test.hooks;

import com.wizzairapp.base.drivers.Driver;
import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Cucumber Hooks responsible for driver lifecycle management.
 * Thread-safe and CI compatible.
 */
public class mobileHooks {

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {

        // 1️⃣ Priority: CI system property
        String platform = System.getProperty("platform");

        // 2️⃣ If not passed via CI, fallback to config default
        if (platform == null || platform.isEmpty()) {
            platform = "android";
        }

        // Load environment-specific config
        ConfigReader config = new ConfigReader(platform);

        // Optional runtime override for deviceName
        String deviceName = System.getProperty("deviceName");
        if (deviceName != null && !deviceName.isEmpty()) {
            config.set("deviceName", deviceName);
        }

        AppiumDriver driver = Driver.createDriver(platform, config);
        DriverManager.setDriver(driver);
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            // Add screenshot logic here later
        }
        DriverManager.quitDriver();
    }
}