package com.oneaston.tap.automation.ui.seleniumutils.webinteractions;

import com.oneaston.tap.automation.ui.seleniumutils.WaitMechanism;
import com.oneaston.tap.automation.ui.seleniumutils.WebElementLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickInteraction {

    final WebElementLocator webElementLocator;
    final WaitMechanism waitMechanism;

    public ClickInteraction(WebDriver driver) {
        webElementLocator = new WebElementLocator(driver);
        waitMechanism = new WaitMechanism(driver);
    }

    /**
     * Click element by providing locator as parameter
     *
     * @param locator String
     */
    public void clickElement(String locator) {
        waitMechanism.waitUntilPageLoadIsComplete();
        WebElement element = webElementLocator.findElement(locator);
        element.click();
    }

}
