package com.wizzairapp.base.pages;

import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.commonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
    public WebElement flightsText;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[1]")
    public WebElement flightsOption;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]")
    public WebElement hotelsOption;

    @AndroidFindBy(id = "com.wizzair.WizzAirApp:id/home_rental_search_button")
    public WebElement hotelSearchOption;

    @AndroidFindBy(id = "com.wizzair.WizzAirApp:id/home_search_searchButtonIcon")
    public WebElement flightSearchOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN IN']")
    public WebElement signIn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'home_search_leavingStation')]")
    public WebElement leavingFromOption;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'home_search_arrivalStation')]")
    public WebElement arrivalToOption;

    public void waitForHomeToLoad() {
        activateApp("com.wizzair.WizzAirApp");
        Assert.assertTrue(utils.isDisplayed(flightsText, "Flights"));
        log.info("Flights Home screen is displayed");
    }
}
