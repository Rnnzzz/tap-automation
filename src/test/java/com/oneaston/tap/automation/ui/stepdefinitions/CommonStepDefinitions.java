package com.oneaston.tap.automation.ui.stepdefinitions;

import com.oneaston.tap.automation.ui.constants.PageName;
import com.oneaston.tap.automation.ui.features.BasePage;
import com.oneaston.tap.automation.ui.features.components.Header;
import com.oneaston.tap.automation.ui.utils.dataprovider.TestProperties;
import com.oneaston.tap.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefinitions {

    protected TestProperties testProperties;
    BasePage basePage = new BasePage(WebDriverFactory.getDriver());
    Header header = new Header(WebDriverFactory.getDriver());

    public CommonStepDefinitions() {
        testProperties = TestProperties.getInstance();
    }

    @Given("I login as Admin user")
    public void iLoginAsAdminUser() {
        basePage.openPage(System.getProperty("tap_url")).login(testProperties.getProperty("wui1_user"), testProperties.getProperty("wui1_pass"));
    }

    @When("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        header.navigateToPage(PageName.valueOf(page.toUpperCase()));
    }


    @Given("I login as Admin user {string}, {string}")
    public void iLoginAsAdminUser(String username, String password) {
        basePage.openPage(System.getProperty("tap_url")).login(username, password);
    }
}
