package test.stepDefinations;

import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.Test;
import util.BaseOptionsUtil;
import util.Driver;

import java.net.MalformedURLException;

public class Hooks {
    private final BaseOptionsUtil baseOptionsUtil = new BaseOptionsUtil();

    @Before
    public void setup() throws MalformedURLException {
        BaseOptions caps = baseOptionsUtil.getBaseOptions();
        Driver.setDriver(caps);
    }

    @After
    public void teardown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                System.out.println("Failed Scenario => " + scenario.getName());
            } else {
                System.out.println(scenario.getStatus() + " => " + scenario.getName());
            }
        } finally {
            if (Driver.getDriver() != null) {
                Driver.getDriver().quit();
            }
        }
    }
}

