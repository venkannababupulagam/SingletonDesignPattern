package com.application.pages.methods;

import com.application.utils.seleniumutils.SeleniumActions;
import com.application.pages.locators.LoginPageLocators;
import com.application.utils.filehandlingutils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends SeleniumActions implements LoginPageLocators {

    WebDriver driver;
    ReadProperties properties;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void performLogin(String userName, String password) {
        enterText(USER_NAME_TEXT_BOX, userName);
        enterText(PASSWORD_TEXT_BOX, password);
        clickOnElement(LOGIN_BUTTON);
    }

    public void verifyLogin() {
        Assert.assertTrue(isElementPresent(LOGO_VERIFY));
    }
}
