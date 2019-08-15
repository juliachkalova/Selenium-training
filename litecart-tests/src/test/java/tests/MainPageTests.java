package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageTests extends BaseTestClass {

    /**
     * Test01 Find stickers and verify that each product has only one sticker
     **/
    @Test
    public void Test01_OnlyOneStickerPerProduct() {
        driver.get("http://localhost/litecart/");
        List<WebElement> products = driver.findElements(By.cssSelector("li.product"));
        for (WebElement product : products) {
            Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() == 1);
        }
    }
}