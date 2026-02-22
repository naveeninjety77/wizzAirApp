package com.wizzairapp.base.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Home page / landing screen interactions (skeleton).
 */
public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    // Locator for Android using UiAutomator text
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FLIGHTS\")")
    public WebElement flightsOption;

    public void waitForHomeToLoad() {
        activateApp("com.wizzair.WizzAirApp");
    }
}
