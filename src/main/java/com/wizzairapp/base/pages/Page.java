package com.wizzairapp.base.pages;

import org.openqa.selenium.support.PageFactory;

/**
 * Home page / landing screen interactions (skeleton).
 */
public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(driver(), this);
    }

    public void waitForHomeToLoad() {

        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }
}
