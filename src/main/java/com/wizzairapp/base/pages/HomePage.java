package com.wizzairapp.base.pages;

import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.commonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Home page / landing screen interactions (skeleton).
 */
public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver) {
        super(driver);
    }
    commonUtils utils = new commonUtils(DriverManager.getDriver());

    // Locator for Android using UiAutomator text
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FLIGHTS']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'FLIGHTS'")
    public WebElement flightsText;


    // Flights Option
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Flights'")
    public WebElement flightsOption;


    // Hotels Option
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Hotel'")
    public WebElement hotelsOption;


    // Hotel Search Button
    @AndroidFindBy(id = "com.wizzair.WizzAirApp:id/home_rental_search_button")
    @iOSXCUITFindBy(accessibility = "home_rental_search_button")
    public WebElement hotelSearchOption;


    // Flight Search Button
    @AndroidFindBy(id = "com.wizzair.WizzAirApp:id/home_search_searchButtonIcon")
    @iOSXCUITFindBy(accessibility = "home_search_searchButtonIcon")
    public WebElement flightSearchOption;


    // SIGN IN
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'SIGN IN'")
    public WebElement signIn;


    // Leaving From
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'home_search_leavingStation')]")
    @iOSXCUITFindBy(accessibility = "home_search_leavingStation")
    public WebElement leavingFromOption;


    // Arrival To
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'home_search_arrivalStation')]")
    @iOSXCUITFindBy(accessibility = "home_search_arrivalStation")
    public WebElement arrivalToOption;

    public void waitForHomeToLoad() {
        activateApp("com.wizzair.WizzAirApp");
        Assert.assertTrue(utils.isDisplayed(flightsText, "Flights"));
        log.info("Flights Home screen is displayed");
    }
}
