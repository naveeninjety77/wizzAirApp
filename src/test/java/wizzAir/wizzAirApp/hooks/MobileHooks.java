package wizzAir.wizzAirApp.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import wizzAir.wizzAirApp.drivers.Driver;
import wizzAir.wizzAirApp.drivers.DriverManager;
import wizzAir.wizzAirApp.utils.ConfigReader;

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
