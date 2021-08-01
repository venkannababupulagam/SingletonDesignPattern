package com.application.pages.methods;

import com.application.base.BrowserSetup;
import com.application.pages.locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage implements LoginPageLocators {

    private static LoginPage loginPage;
    BrowserSetup base = BrowserSetup.getBase();
    WebDriver driver = base.getDriver();

    /**
     * Implemented this class as singleton class
     */
    private LoginPage() {
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


    public void performLogin(String userName, String password) {
        enterText(USER_NAME_TEXT_BOX, userName);
        enterText(PASSWORD_TEXT_BOX, password);
        clickOnElement(LOGIN_BUTTON);
    }

    public void verifyLogin() {
        Assert.assertTrue(isElementPresent(LOGO_VERIFY));
    }


    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        boolean isDisplayed = driver.findElement(locator).isDisplayed();
        return isDisplayed;
    }
}
