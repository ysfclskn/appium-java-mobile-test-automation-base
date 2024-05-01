package test.stepDefinations;

import io.cucumber.java.en.Then;
import test.pages.ProductListPage;

public class ProductListSteps extends ProductListPage {

    @Then("verify products is exist on products page")
    public void verifyProductsIsExistOnProductsPage() {
        verifyProductsIsExist();
    }
}