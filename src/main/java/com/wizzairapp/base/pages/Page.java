package com.wizzairapp.base.pages;


import com.wizzairapp.base.drivers.DriverManager;
import io.appium.java_client.AppiumDriver;

/**
 * Page have all the objects of the pages
 */

    public class Page {

        private AppiumDriver driver;

        public Page() {
            this.driver = DriverManager.getDriver();
        }

        public HomePage homePO() {
            return new HomePage(driver);
        }

        public LoginPage loginPO() {
            return new LoginPage(driver);
        }

    public FlightPage flightPO() {
        return new FlightPage(driver);
    }

}
