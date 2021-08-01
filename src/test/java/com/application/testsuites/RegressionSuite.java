package com.application.testsuites;

import com.application.base.BrowserSetup;
import com.application.dataproviders.LoginPageDataProvider;
import com.application.pages.methods.LoginPage;
import com.application.utils.filehandlingutils.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.application.utils.commons.CommonVariables.configfilePath;

public class RegressionSuite {

    LoginPage loginPage;
    ReadProperties properties;
    BrowserSetup base = BrowserSetup.getBase();
    WebDriver driver = base.getDriver();

    @BeforeMethod
    public void launchApplication() {
        properties = new ReadProperties(configfilePath);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "loginData", dataProviderClass = LoginPageDataProvider.class)
    public void verifyUserLogin(String userName, String password) {
        loginPage = LoginPage.getLoginPage();
        loginPage.performLogin(userName, password);
        loginPage.verifyLogin();
    }


    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
