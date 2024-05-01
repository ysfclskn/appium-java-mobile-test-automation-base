package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static AppiumDriver driver;

    public static void setDriver(BaseOptions baseOptions) throws MalformedURLException {
        String appiumAddress = System.getProperty("appiumURL", ConfigReader.get("appiumURL"));
        URL appiumURL = new URL(appiumAddress);
        driver = new AppiumDriver(appiumURL, baseOptions);
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
