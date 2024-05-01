package test.stepDefinations;

import io.cucumber.java.en.When;
import test.pages.HomePage;

public class HomePageSteps extends HomePage {

    @When("click product list on homepage")
    public void clickProductListOnHomepage() {
        clickProductListButton();
    }

}
