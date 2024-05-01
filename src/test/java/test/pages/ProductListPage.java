package test.pages;

import org.openqa.selenium.By;
import util.PageHelper;

import java.util.Random;

public class ProductListPage extends PageHelper {

    Random random = new Random();
    String productCard = "//android.widget.TextView[@resource-id=\"com.example.pocandroidapp:id/productName\" and @text=\"%s\"]";

    public void verifyProductsIsExist() {
        verifyIsElementExist(By.xpath(String.format(productCard, getRandomProductName())));
    }

    public String getRandomProductName() {
        return "Product " + random.nextInt(5);
    }
}
