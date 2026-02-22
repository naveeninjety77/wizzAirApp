package com.wizzairapp.base.hooks;

import com.wizzairapp.base.drivers.Driver;
import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Cucumber Hooks responsible for driver lifecycle management.
 * Thread-safe and CI compatible.
 */
public class mobileHooks {
    private static final Logger log = LoggerFactory.getLogger(mobileHooks.class);

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
        log.info("========== START SCENARIO: {} ==========", scenario.getName());
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            // Add screenshot logic here later
        }
        DriverManager.quitDriver();
        log.info("========== END SCENARIO: {} | STATUS: {} ==========", scenario.getName(), scenario.getStatus());
    }
}