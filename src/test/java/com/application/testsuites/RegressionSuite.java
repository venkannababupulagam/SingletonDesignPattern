package com.application.testsuites;

import com.application.base.BrowserSetup;
import com.application.dataproviders.LoginPageDataProvider;
import com.application.pages.methods.Homepage;
import com.application.pages.methods.LoginPage;
import com.application.utils.filehandlingutils.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.application.utils.commons.CommonVariables.configfilePath;

public class RegressionSuite extends BrowserSetup {

    LoginPage loginPage;
    Homepage homepage;
    ReadProperties properties;

    @BeforeMethod
    public void launchApplication() {
        properties = new ReadProperties(configfilePath);
        getDriver().get(properties.getProperty("AppUrl"));
    }

    @Test(dataProvider = "loginData", dataProviderClass = LoginPageDataProvider.class)
    public void verifyUserLogin(String userName, String password) {
        loginPage = new LoginPage(getDriver());
        loginPage.performLogin(userName, password);
        loginPage.verifyLogin();
    }


    @Test(description = "This test case is to verify the logo in HomePage")
    public void verifyHomepageLogo() {
        homepage = new Homepage(getDriver());
        homepage.verifyHomePageLogo();
    }
}
