package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import util.PageHelper;

public class LoginPage extends PageHelper {

    By txtUsername = By.id("com.example.pocandroidapp:id/username");
    By txtPassword = By.id("com.example.pocandroidapp:id/password");
    By btnLogin = By.id("com.example.pocandroidapp:id/loginButton");
    By lblLogin = By.id("com.example.pocandroidapp:id/successMessage");

    public void fillUsername(String username) {
        sendKey(txtUsername, username);
    }

    public void fillPassword(String password) {
        sendKey(txtPassword, password);
    }

    public void clickLogin() {
        clickElement(btnLogin);
    }

    public void verifyLogin() {
        String loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(lblLogin)).getText();
        Assert.assertTrue(loginMessage.trim().toLowerCase().contains("login successful!"));
    }
}
