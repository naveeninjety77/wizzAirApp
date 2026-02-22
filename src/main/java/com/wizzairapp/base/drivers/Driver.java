package com.wizzairapp.base.drivers;


import java.net.MalformedURLException;
import java.net.URL;

import com.wizzairapp.base.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

/**
 * Factory class responsible for creating AppiumDriver instances for Android and
 * iOS (Emulator + Real Devices).
 */
public final class Driver {

	private Driver() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static AppiumDriver createDriver(String platform, ConfigReader cfg) {

		String normalizedPlatform = (platform == null || platform.isEmpty()) ? "android"
				: platform.trim().toLowerCase();

		String server = require(cfg.get("appiumServer", null), "Appium server URL is not configured.");

		try {
	        URL serverUrl = new URL(server);

	        switch (normalizedPlatform) {
	            case "android":
	                return createAndroidDriver(serverUrl, cfg);

	            case "ios":
	                return createIOSDriver(serverUrl, cfg);

	            default:
	                throw new IllegalArgumentException(
	                        "Unsupported platform: " + platform);
	        }

		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("Invalid Appium server URL: " + server, e);
		}
	}

	// ================= ANDROID =================

	private static AppiumDriver createAndroidDriver(URL serverUrl, ConfigReader cfg) {

		UiAutomator2Options options = new UiAutomator2Options().setDeviceName(cfg.get("deviceName", "Android Emulator"))
				.setAutomationName("UiAutomator2");

		setIfPresent(cfg.get("platformVersion", null), options::setPlatformVersion);
		setIfPresent(cfg.get("udid", null), options::setUdid);
		setIfPresent(cfg.get("appPath", null), options::setApp);
		setIfPresent(cfg.get("appPackage", null), options::setAppPackage);
		setIfPresent(cfg.get("appActivity", null), options::setAppActivity);

		options.setNoReset(Boolean.parseBoolean(cfg.get("noReset", "false")));
		options.setFullReset(Boolean.parseBoolean(cfg.get("fullReset", "false")));

		return new AppiumDriver(serverUrl, options);
	}

	// ================= IOS =================

	private static AppiumDriver createIOSDriver(URL serverUrl, ConfigReader cfg) {

		XCUITestOptions options = new XCUITestOptions().setDeviceName(cfg.get("deviceName", "iPhone Simulator"))
				.setAutomationName("XCUITest");

		setIfPresent(cfg.get("platformVersion", null), options::setPlatformVersion);
		setIfPresent(cfg.get("udid", null), options::setUdid);
		setIfPresent(cfg.get("appPath", null), options::setApp);

		options.setNoReset(Boolean.parseBoolean(cfg.get("noReset", "false")));
		options.setFullReset(Boolean.parseBoolean(cfg.get("fullReset", "false")));

		return new AppiumDriver(serverUrl, options);
	}

	// ================= UTILITIES =================

	private static String require(String value, String message) {
		if (value == null || value.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
		return value;
	}

	private static void setIfPresent(String value, java.util.function.Consumer<String> setter) {
		if (value != null && !value.isEmpty()) {
			setter.accept(value);
		}
	}
}