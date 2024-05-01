package test.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.stepDefinations.Hooks;

@CucumberOptions(
        plugin = {"html:target/cucumber-html-report.html",
                "pretty"
        },
        monochrome = true,
        features = "src/test/java/test/features",
        glue = "test.stepDefinations",
        publish = true
)

public class TestRunner extends Hooks {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = {"cucumber"}, dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        if (!pickleWrapper.getPickle().getTags().contains("@ignore")) {
            this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        } else {
            throw new SkipException("Skipped Test");
        }

    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
