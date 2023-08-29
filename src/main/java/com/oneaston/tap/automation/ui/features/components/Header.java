package com.oneaston.tap.automation.ui.features.components;

import com.oneaston.tap.automation.ui.constants.PageName;
import com.oneaston.tap.automation.ui.features.BasePage;
import com.oneaston.tap.automation.ui.seleniumutils.WebElementLocator;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.HoverInteraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Header extends BasePage {

    final HoverInteraction hoverInteraction;
    final ClickInteraction clickInteraction;
    final WebElementLocator webElementLocator;
    final Actions actions;


    public Header(WebDriver driver) {
        super(driver);
        hoverInteraction = new HoverInteraction(driver);
        clickInteraction = new ClickInteraction(driver);
        webElementLocator = new WebElementLocator(driver);
        actions = new Actions(driver);
    }

    public void navigateToPage(PageName pageName) {
        openOrderPage(pageName.getPageName());
    }

    private void openOrderPage(String orderPage) {
        actions.moveToElement(webElementLocator.findElement("M1_3")).moveToElement(webElementLocator.findElement("M1_3_1"))
                .click(webElementLocator.findElement("//span[text()='" + orderPage + "']")).perform();
    }
}
