package com.application.pages.methods;

import com.application.pages.locators.HomepageLocators;
import com.application.utils.seleniumutils.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage extends SeleniumActions implements HomepageLocators {

    WebDriver driver;

    public Homepage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyHomePageLogo() {
        waitForSeconds(2);
        Assert.assertTrue(isElementPresent(HOMEPAGE_LOGO));
    }
}
