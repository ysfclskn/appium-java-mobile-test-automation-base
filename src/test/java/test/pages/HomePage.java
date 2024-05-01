package test.pages;

import org.openqa.selenium.By;
import util.PageHelper;

public class HomePage extends PageHelper {

    By productListButton = By.id("com.example.pocandroidapp:id/listProductsButton");

    public void clickProductListButton() {
        clickElement(productListButton);
    }
}
