package com.application.pages.locators;

import org.openqa.selenium.By;

public interface LoginPageLocators {

    By USER_NAME_TEXT_BOX = By.xpath(String.format("//input[@name='user-name']"));
    By PASSWORD_TEXT_BOX = By.xpath(String.format("//input[@name='password']"));
    By LOGIN_BUTTON = By.xpath(String.format("//input[@name='login-button']"));
    By LOGO_VERIFY = By.xpath(String.format("//span[text()='Products']"));
}
