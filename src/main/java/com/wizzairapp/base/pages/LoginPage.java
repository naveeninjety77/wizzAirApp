package com.wizzairapp.base.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLoginScreen() {
        // wait for login screen elements to appear
        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
    }

    public void ensureOnLoginScreen() {
        waitForLoginScreen();
    }

    public void enterUsername(String username) {
        // type username into username field
    }

    public void enterPassword(String password) {
        // type password into password field
    }

    public void tapLogin() {
        // tap login button
    }

    public void assertLoggedIn() {
        // verify successful login, e.g. presence of homepage element
    }

    public void assertLoginError() {
        // verify error message is displayed
    }
}
