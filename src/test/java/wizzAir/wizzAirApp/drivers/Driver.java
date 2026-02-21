package wizzAir.wizzAirApp.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import wizzAir.wizzAirApp.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This Class responsible for creating AppiumDriver instances for supported platforms.
 */
public final class Driver {

    private Driver() {
    }

    public static AppiumDriver<WebElement> createDriver(String platform, ConfigReader cfg) {
        platform = platform == null ? "android" : platform.toLowerCase();
        String server = cfg.get("appiumServer", "");

        try {
            URL serverUrl = new URL(server);

            if (platform.equals("android")) {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(cfg.get("deviceName", "Android Emulator"));
                options.setApp(cfg.get("appPath", "./src/test/resources/apps/android.apk"));
                options.setAutomationName(cfg.get("automationName", "UiAutomator2"));
                String platformVersion = cfg.get("platformVersion", null);
                if (platformVersion != null) options.setPlatformVersion(platformVersion);
                return new AppiumDriver<>(serverUrl, options);

            } else if (platform.equals("ios")) {
                XCUITestOptions options = new XCUITestOptions();
                options.setDeviceName(cfg.get("deviceName", "iPhone Simulator"));
                options.setApp(cfg.get("appPath", "./src/test/resources/apps/ios.app"));
                options.setAutomationName(cfg.get("automationName", "XCUITest"));
                String platformVersion = cfg.get("platformVersion", null);
                if (platformVersion != null) options.setPlatformVersion(platformVersion);
                return new AppiumDriver<>(serverUrl, options);

            } else {
                throw new IllegalArgumentException("Unsupported platform: " + platform);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}
