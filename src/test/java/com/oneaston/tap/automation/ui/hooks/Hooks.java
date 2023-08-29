package com.oneaston.tap.automation.ui.hooks;

import com.oneaston.tap.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Before
    public static void setUp() {
        {
            System.setProperty("tap_url", "https://172.31.29.91:15051/wui/activity/index");
        }
        WebDriverFactory.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {
        WebDriverFactory.tearDown();
    }

    @AfterStep
    public static void captureEvidence(Scenario scenario) {
        takeScreenshot(scenario);
    }

    private static void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getId() + scenario.getName() + getTimeStamp());
    }

    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
        return (sdf.format(new Date()));
    }

}
