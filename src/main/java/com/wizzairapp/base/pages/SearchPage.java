package com.wizzairapp.base.pages;

/**
 * Search page skeleton – implement locators and interactions against your app.
 */
import io.appium.java_client.AppiumDriver;

public class SearchPage extends BasePage {

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void openSearch() {
        // navigate to search screen if needed
    }

    public void enterOrigin(String origin) {
        // locate origin field and type
    }

    public void enterDestination(String destination) {
        // locate destination field and type
    }

    public void selectDepartureInDays(int daysFromToday) {
        // choose date relative to today
    }

    public void tapSearch() {
        // tap search button
    }

    public void assertResultsPresent() {
        // assert that result list is present
    }

    public void assertAtLeastOneFare() {
        // assert that at least one fare exists
    }
}
