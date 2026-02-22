package com.wizzairapp.base.pages;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.wizzairapp.base.drivers.DriverManager;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Minimal base page that provides driver access and a helper to take screenshots.
 */
public abstract class BasePage {

    protected AppiumDriver driver() {
        return DriverManager.getDriver();
    }

    protected void takeScreenshot(String name) {
        try {
            AppiumDriver d = driver();
            if (d == null) return;
            File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
            Path dst = Path.of("target", "screenshots", name + ".png");
            Files.createDirectories(dst.getParent());
            Files.copy(src.toPath(), dst);
        } catch (Exception ignored) {
        }
    }
}
