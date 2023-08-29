package com.oneaston.tap.automation.ui.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/html-results/cucumber_result.html",
                "json:target/cucumber-reports/json-result/cucumber_result.xml"},
        features = {"src/test/resources/features/Bond.feature"},
        glue = {"com.oneaston.tap.automation.ui.stepdefinitions",
                "com.oneaston.tap.automation.ui.hooks"},

        monochrome = true,
        publish = true)

@Test
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(dataProvider = "scenarios")
//    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
//        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
//    }
//
//    @DataProvider(name = "scenarios", parallel = true)
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        testNGCucumberRunner.finish();
//    }

}
