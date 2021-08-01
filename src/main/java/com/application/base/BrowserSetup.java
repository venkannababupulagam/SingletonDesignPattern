package com.application.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {

    /**
     * Create a Private Static variable of Class type
     */
    private static BrowserSetup base = null;
    /**
     * Implemented Singleton Design Pattern (BrowserSetup is now a Single ton class -> It restricts the instantiation to one 'Single' object)
     */

    private final WebDriver driver;

    /**
     * Make Default Constructor as private
     */
    private BrowserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    /**
     * Initialize the above class variable in a public static method
     */
    public static BrowserSetup getBase() {
        if (base == null) {
            base = new BrowserSetup();
        }
        return base;
    }

    /**
     * Getter method to access the driver
     */

    public WebDriver getDriver() {
        return driver;
    }
}
