package com.wizzairapp.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"wizzAir.wizzAirApp.stepdefs", "wizzAir.wizzAirApp.hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    // Extends the TestNG Cucumber runner. Add TestNG configuration in testng.xml as needed.
}
