package com.oneaston.tap.automation.ui.seleniumutils;

import org.openqa.selenium.*;

import java.util.List;

public class WebElementLocator {

    private final WebDriver driver;

    public WebElementLocator(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String locator) {
        WebElement element = driver.findElement(setLocatorType(locator));
        scrollIntoView(element);
        return element;
    }


    public WebElement findElement(WebElement element, String locator) {
//        try {
            scrollIntoView(element);
            return element.findElement(By.xpath(locator));
//        } catch (NoSuchElementException noSuchElementException) {
//            AssertionUtil.reportFail(driver, logger, "Unable to find element with locator - " + locator);
//        } catch (Exception e) {
//            AssertionUtil.reportFail(driver, logger, "Error in finding element - " + e.getMessage());
//        }
//        return null;
    }

    public List<WebElement> findElements(String locator) {
        List<WebElement> elements = driver.findElements(setLocatorType(locator));
        scrollIntoView(elements.get(0));
        return elements;
    }

    private By setLocatorType(String locator) {
        if (locator.startsWith("//")) {
            return By.xpath(locator);
        } else {
            return By.id(locator);
        }
    }

    private void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
    }

}
