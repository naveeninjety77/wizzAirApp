package com.wizzairapp.base.pages;


import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.wizzairapp.base.drivers.DriverManager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Minimal base page that provides driver access and a helper to take screenshots.
 */
public abstract class BasePage {

    protected AppiumDriver driver;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this
        );
    }

    protected void takeScreenshot(String name) {
        try {
            if (driver == null) return;
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dst = Path.of("target", "screenshots", name + ".png");
            Files.createDirectories(dst.getParent());
            Files.copy(src.toPath(), dst);
        } catch (Exception ignored) {
        }
    }

    public void activateApp(String appId) {
        if (driver instanceof InteractsWithApps) {
            ((InteractsWithApps) driver).activateApp(appId);
        }
    }
}
