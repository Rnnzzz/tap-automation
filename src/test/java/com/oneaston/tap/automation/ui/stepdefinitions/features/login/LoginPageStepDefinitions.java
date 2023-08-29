package com.oneaston.tap.automation.ui.stepdefinitions.features.login;

import com.oneaston.tap.automation.ui.features.BasePage;
import com.oneaston.tap.automation.ui.features.dashboard.DashboardPage;
import com.oneaston.tap.automation.ui.features.login.LoginPage;
import com.oneaston.tap.automation.ui.utils.assertions.AssertionUtility;
import com.oneaston.tap.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageStepDefinitions {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("I open OneView page")
    public void iOpenOneViewPage() {
        BasePage basePage = new BasePage(WebDriverFactory.getDriver());
        loginPage = basePage.openPage(System.getProperty("ov_url"));
    }

    @When("User enters username as {string} and password as {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        dashboardPage = loginPage.login(username, password);
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyIfAbleToLogin() {
        AssertionUtility.assertTrue(dashboardPage.getCurrentUrl().contains("dashboard"), "Unable to login");
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }

}