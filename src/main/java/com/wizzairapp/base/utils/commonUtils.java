package com.wizzairapp.base.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.appium.java_client.AppiumDriver;

public class commonUtils {
    private final AppiumDriver driver;
    private static final Logger log =
            LoggerFactory.getLogger(commonUtils.class);

    public commonUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    private Wait<AppiumDriver> getWait(int timeout, int polling) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(polling))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public WebElement waitForVisibility(WebElement element) {
        return getWait(15, 500)
                .until(d -> element.isDisplayed() ? element : null);
    }

    public WebElement waitForClickable(WebElement element) {
        return getWait(15, 500)
                .until(d -> element.isDisplayed() && element.isEnabled() ? element : null);
    }

    public boolean waitForInvisibility(WebElement element) {
        return getWait(15, 500)
                .until(d -> !element.isDisplayed());
    }
}
