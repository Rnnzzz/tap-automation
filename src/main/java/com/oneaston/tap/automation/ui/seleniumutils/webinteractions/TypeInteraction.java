package com.oneaston.tap.automation.ui.seleniumutils.webinteractions;

import com.oneaston.tap.automation.ui.seleniumutils.WaitMechanism;
import com.oneaston.tap.automation.ui.seleniumutils.WebElementLocator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypeInteraction {

    private final WebElementLocator webElementLocator;
    private final WaitMechanism waitActions;


    public TypeInteraction(WebDriver driver) {
        webElementLocator = new WebElementLocator(driver);
        waitActions = new WaitMechanism(driver);
    }

    /**
     * Type character sequence by providing locator as parameter
     *
     * @param locator String
     * @param text    String
     */
    public void type(String locator, CharSequence text) {
        try {
            waitActions.waitUntilPageLoadIsComplete();
            WebElement element = webElementLocator.findElement(locator);
            element.clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException | NoSuchElementException exception) {
            type(locator, text);
        }
    }
}
