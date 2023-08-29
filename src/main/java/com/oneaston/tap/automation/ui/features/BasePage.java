package com.oneaston.tap.automation.ui.features;

import com.oneaston.tap.automation.ui.features.login.LoginPage;
import com.oneaston.tap.automation.ui.seleniumutils.WebElementLocator;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public final WebElementLocator webElementLocator;
    protected final WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        webElementLocator = new WebElementLocator(driver);
    }

    public LoginPage openPage(String url) {
        driver.get(url);
        return new LoginPage(driver);
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
