package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageHelper {
    protected WebDriverWait wait;
    protected AppiumDriver driver = Driver.getDriver();

    public PageHelper() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void sendKey(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void verifyIsElementExist(By by) {
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementError => Element Not Found");
        }
    }

}
