package com.wizzairapp.base.pages;

import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.commonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Home page / landing screen interactions (skeleton).
 */
public class FlightPage extends BasePage {

    public FlightPage(AppiumDriver driver) {
        super(driver);
    }
    private static final String AIRPORT_CODE = "";

    // Locator for Android using UiAutomator text
    @AndroidFindBy(id = "com.wizzair.WizzAirApp:id/airport_list_searchbar")
    public WebElement airportSearchInput;

    @AndroidFindBy(id = "com.wizzair.WizzAirApp:id/home_searchDates_departureField")
    public WebElement departureSelectDate;

    public WebElement airportCode(String airportCode) {
        return driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'airport_list_item_code') and @text='"+airportCode+"']"));
    }

}
