package com.application.base;

import com.application.utils.filehandlingutils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.application.utils.commons.CommonVariables.configfilePath;

public class BrowserSetup {

    private static WebDriver driver;
    ReadProperties properties;
    Logger logger = LogManager.getLogger(getClass().getName());

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public WebDriver initializeBrowser() {
        properties = new ReadProperties(configfilePath);
        String Browser = properties.getProperty("Browser");
        logger.info("Selected Browser is : " + Browser);
        if (Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Chrome Driver Launched Successfully");
        } else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox Driver Launched Successfully");
        } else {
            logger.error(Browser + " is not found");
        }
        driver.manage().window().maximize();
        logger.info("Browser is maximized");
        return driver;
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        logger.info("Browser closed successfully");
    }
}
