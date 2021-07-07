package com.application.utils.seleniumutils;

import com.application.utils.synchronization.Waits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumActions extends Waits {

    WebDriver driver;
    Logger logger = LogManager.getLogger(getClass().getName());

    public SeleniumActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        logger.info("Navigated to " + url);
    }

    public void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        logger.info("Entered " + text + " in " + locator + " Field");
    }

    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
        logger.info("Clicked on element associated with " + locator);
    }

    public boolean isElementPresent(By locator) {
        boolean isDisplayed = driver.findElement(locator).isDisplayed();
        logger.info(isDisplayed ? "Element with the locator " + locator + " is displayed" : "Element with the locator " + locator + " is not displayed");
        return isDisplayed;
    }
}
