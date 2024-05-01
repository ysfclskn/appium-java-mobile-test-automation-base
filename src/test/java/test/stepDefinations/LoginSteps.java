package test.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.pages.LoginPage;

public class LoginSteps extends LoginPage {

    @Given("fill user name with {string} on the page")
    public void fillUserNameWithOnThePage(String username) {
        fillUsername(username);
    }

    @Given("login with registered user on login page")
    public void loginWithRegisteredUser() {
        fillUsername("kloia");
        fillPassword("kloia1234");
        clickLogin();
    }

    @Given("fill password with {string} on the page")
    public void fillPasswordWithOnThePage(String password) {
        fillPassword(password);
    }

    @When("click login on the page")
    public void clickLoginOnThePage() {
        clickLogin();
    }

    @Then("verify successful login")
    public void verifySuccessfulLogin() {
        verifyLogin();
    }

}
