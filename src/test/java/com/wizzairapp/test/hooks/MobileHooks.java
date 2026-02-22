package com.wizzairapp.test.hooks;

import com.wizzairapp.base.drivers.Driver;
import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Cucumber hooks that initialize and tear down Appium sessions in a thread-safe
 */
public class MobileHooks {

	@Before(order = 0)
	public void beforeScenario() {
		ConfigReader cfg = ConfigReader.getInstance();
		String platform = cfg.get("platform", "android");

		// Create and register the driver for the current thread
		DriverManager.setDriver(Driver.createDriver(platform, cfg));
	}

	@After
	public void afterScenario() {
		// Quit and remove driver for current thread
		DriverManager.quitDriver();
	}
}
