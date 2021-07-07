package com.application.utils.synchronization;

import com.application.listeners.Reports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    WebDriver driver;
    Logger logger = LogManager.getLogger(getClass().getName());

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSeconds(int seconds) {
        logger.info("Waiting for "+seconds+" Seconds");
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void explicitWait(By locator, int seconds) {
        logger.info("Waiting for "+seconds+" Seconds before clicking on the "+locator+" locator");
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
