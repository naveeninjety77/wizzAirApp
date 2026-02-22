package com.wizzairapp.test.runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/login.feature", glue = { "com.wizzairapp.test.stepdefs",
		"com.wizzairapp.base.hooks" }, plugin = { "pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber.json" })
public class testRunner extends AbstractTestNGCucumberTests {
	@BeforeClass(alwaysRun = true)
	@Parameters({ "platform", "deviceName" })
	public void setUp(@Optional("") String platform, @Optional("") String deviceName) {

		// Set environment variable for CI/CD
		if (!platform.isEmpty() && System.getProperty("platform") == null) {
			System.setProperty("platform", platform);
		}

		if (!deviceName.isEmpty() && System.getProperty("deviceName") == null) {
			System.setProperty("deviceName", deviceName);
		}
	}

	/**
	 * Enables scenario-level parallel execution.
	 */
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}