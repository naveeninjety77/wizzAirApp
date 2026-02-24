package com.wizzairapp.test.stepdefs;

import com.wizzairapp.base.drivers.DriverManager;
import com.wizzairapp.base.utils.commonUtils;
import com.wizzairapp.base.pages.Page;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class searchFlightSteps {
    private static final Logger log =
            LoggerFactory.getLogger(searchFlightSteps.class);
    commonUtils utils = new commonUtils(DriverManager.getDriver());

    private Page page;

    @Before
    public void init() {
        page = new Page();
    }

    @Given("The user is on the flight search screen")
    public void userIsOnFlightSearchScreen() {
        Assert.assertTrue(utils.isDisplayed(page.homePO().signIn, "Sign In"));
        Assert.assertTrue(utils.isDisplayed(page.homePO().leavingFromOption,"Leaving From option"));
        Assert.assertTrue(utils.isDisplayed(page.homePO().arrivalToOption,"Arrival to option"));
        Assert.assertTrue(utils.isDisplayed(page.homePO().flightSearchOption,"Flight Search option"));
    }

    @When("The user searches for flights from {string} to {string} on {string}")
    public void userSearchesForFlights(String from, String destination, String date) {
        // Search and select from airport code
        utils.waitForClickable(page.homePO().leavingFromOption, "From Field").click();
        utils.waitForVisibility(page.flightPO().airportSearchInput, "Leaving from search box");
        page.flightPO().airportSearchInput.sendKeys(from);
        utils.scrollToText(from);
        utils.waitForVisibility(page.flightPO().airportCode(from), "From Airport code").click();
        Assert.assertTrue(utils.isDisplayed(page.homePO().leavingFromOption, "From Field"));

        // Search and select from airport code
        utils.waitForClickable(page.homePO().arrivalToOption, "Arrival Field").click();
        utils.waitForVisibility(page.flightPO().airportSearchInput, "Destination search box");
        page.flightPO().airportSearchInput.sendKeys(destination);
        utils.scrollToText(destination);
        utils.waitForVisibility(page.flightPO().airportCode(destination), "Destination Airport code").click();
        Assert.assertTrue(utils.isDisplayed(page.homePO().arrivalToOption, "Destination Field"));

        utils.waitForVisibility(page.flightPO().departureSelectDate, "departure select date").click();
//        utils.selectDate(date);

        utils.waitForClickable(page.homePO().flightSearchOption, "Search Button");
    }

    @When("the user scrolls through search results")
    public void userScrollsThroughResults() {
//        resultsPage.scrollThroughResults();
    }

    @Then("the flight {string} should appear in the results list")
    public void verifyFlightInResults(String flightNumber) {
//        Assert.assertTrue(
//                resultsPage.isFlightDisplayed(flightNumber),
//                "Flight " + flightNumber + " not found in results"
//        );
    }
}