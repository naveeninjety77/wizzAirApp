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

public class LoginSteps {
    private static final Logger log =
            LoggerFactory.getLogger(LoginSteps.class);
    commonUtils utils = new commonUtils(DriverManager.getDriver());

    private Page page;

    @Before
    public void init() {
        page = new Page();
    }

    @Given("the app is launched")
    public void theAppIsLaunched() {
        page.homePO().waitForHomeToLoad();
        utils.waitForVisibility(page.homePO().flightsOption);
        page.homePO().flightsOption.isDisplayed();
        log.info("Home screen is displayed");
    }

    @Then("I am on the login screen")
    public void i_should_see_available_flights() {
//        search.assertResultsPresent();
    }
}
