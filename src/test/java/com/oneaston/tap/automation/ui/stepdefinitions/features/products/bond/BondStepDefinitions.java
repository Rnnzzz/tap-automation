package com.oneaston.tap.automation.ui.stepdefinitions.features.products.bond;

import com.oneaston.tap.automation.ui.features.products.bond.BondsOrderPage;
import com.oneaston.tap.automation.ui.utils.assertions.AssertionUtility;
import com.oneaston.tap.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BondStepDefinitions {

    BondsOrderPage bondsOrderPage = new BondsOrderPage(WebDriverFactory.getDriver());

    @Then("I should be able to see bond page")
    public void iShouldBeAbleToSeeBondPage() {
        AssertionUtility.assertElementDisplayed(bondsOrderPage.webElementLocator.findElement("//b[text()='Create Bond Order']"));
    }

    @Then("The order status should be {string}")
    public void orderStatusShouldBe(String status) {
        AssertionUtility.assertTextEquals(bondsOrderPage.getInteraction.getElementText("//label[text()='Status']/parent::td/following-sibling::td[1]/b"), status);
    }

    @When("I create order bonds")
    public void iCreateOrderBond() {

    }

    @When("I create order bonds with {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void iCreateOrderBondsWith(String portfolio, String instrument, String nominalPrice, String clientPrice, String spread, String phone, String instructedBy, String contact, String overrideReason) {
        bondsOrderPage.createBondOrder(portfolio, instrument, nominalPrice, clientPrice, spread, phone, instructedBy, contact, overrideReason);
    }
}
