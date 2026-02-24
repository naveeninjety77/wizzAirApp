package com.wizzairapp.base.utils;

import java.time.Duration;

import io.appium.java_client.AppiumBy;
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

    public WebElement waitForVisibility(WebElement element, String elementName) {
        //Waiting for element to be visible
        try {
            WebElement visibleElement = getWait(15, 500).until(driver -> {
                try {
                    return element.isDisplayed() ? element : null;
                } catch (Exception e) {
                    return null;
                }
            });

            log.info("{} is visible.", elementName);
            return visibleElement;

        } catch (Exception e) {
            log.error("{} was not visible within timeout.", elementName, e);
            throw e;
        }
    }


    public WebElement waitForClickable(WebElement element, String elementName) {
        //Waiting for element to be clickable
        try {
            WebElement clickableElement = getWait(15, 500).until(driver -> {
                try {
                    return (element.isDisplayed() && element.isEnabled()) ? element : null;
                } catch (Exception e) {
                    return null;
                }
            });
            log.info("{} is clickable.", elementName);
            return clickableElement;

        } catch (Exception e) {
            log.error("{} was not clickable within timeout.", elementName, e);
            throw e;
        }
    }


    public boolean waitForInvisibility(WebElement element, String elementName) {
        //Waiting for element to become invisible
        try {
            boolean result = getWait(15, 500).until(driver -> {
                try {
                    return !element.isDisplayed();
                } catch (Exception e) {
                    return true; // stale or not found = invisible
                }
            });
            log.info("{} is now invisible.", elementName);
            return result;

        } catch (Exception e) {
            log.error("{} did not become invisible within timeout.", elementName, e);
            return false;
        }
    }


    public boolean isDisplayed(WebElement element, String elementName) {
       //Checking if element is displayed
        try {
            waitForVisibility(element,elementName);
            log.info("{} is displayed.", elementName);
            return true;
        } catch (Exception e) {
            log.error("{} is NOT displayed.", elementName, e);
            return false;
        }
    }

    public WebElement scrollToText(String text) {

        String platform = driver.getCapabilities()
                .getPlatformName()
                .toString()
                .toLowerCase();

        log.info("Scrolling to text [{}] on platform [{}]", text, platform);

        if (platform.contains("android")) {
            return scrollAndroid(text);
        } else {
            return scrollIOS(text);
        }
    }

    // Android implementation
    private WebElement scrollAndroid(String text) {

        String uiScrollable =
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"));";

        return driver.findElement(AppiumBy.androidUIAutomator(uiScrollable));
    }

    // iOS implementation
    private WebElement scrollIOS(String text) {

        int maxSwipes = 5;

        for (int i = 0; i < maxSwipes; i++) {

            var elements = driver.findElements(
                    AppiumBy.iOSNsPredicateString("label CONTAINS '" + text + "'"));

            if (!elements.isEmpty()) {
                return elements.get(0);
            }

            swipeUp();
        }

        throw new RuntimeException("Text not found after scrolling: " + text);
    }

    private void swipeUp() {
        driver.executeScript("mobile: swipe", java.util.Map.of("direction", "up"));
    }
}
