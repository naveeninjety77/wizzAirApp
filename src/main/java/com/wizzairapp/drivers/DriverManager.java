package com.wizzairapp.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Thread-safe holder for AppiumDriver instances. Uses ThreadLocal so tests can
 * run in parallel without sharing driver state.
 */
public final class DriverManager {
    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
        // utility
    }

    public static void setDriver(AppiumDriver driver) {
        DRIVER.set(driver);
    }

    public static AppiumDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitDriver() {
        AppiumDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            }
            DRIVER.remove();
        }
    }
}
