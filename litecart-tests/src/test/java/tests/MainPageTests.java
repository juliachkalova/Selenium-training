package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageTests extends BaseTestClass {

    /**
     * Test01 Find stickers on Most Popular section and verify that each product has only one sticker
     **/
    @Test
    public void Test01_FindStickersOnMostPopularSection() {
        driver.get("http://localhost/litecart/");
        WebElement mostPopularSection = driver.findElement(By.id("box-most-popular"));
        List<WebElement> products = mostPopularSection.findElements(By.tagName("li"));
        for (WebElement product : products) {
            Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() == 1);
        }
    }

    /**
     * Test02 Find stickers on Campaings section and verify that each product has only one sticker
     **/
    @Test
    public void Test02_FindStickersOnCampaingsSection() {
        driver.get("http://localhost/litecart/");
        WebElement campaingsSection = driver.findElement(By.id("box-campaigns"));
        List<WebElement> products = campaingsSection.findElements(By.tagName("li"));
        for (WebElement product : products) {
            Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() == 1);
        }
    }

    /**
     * Test03 Find stickers on Latest Products section and verify that each product has only one sticker
     **/
    @Test
    public void Test03_FindStickersOnLatestProductsSection() {
        driver.get("http://localhost/litecart/");
        WebElement latestProductsSection = driver.findElement(By.id("box-latest-products"));
        List<WebElement> products = latestProductsSection.findElements(By.tagName("li"));
        for (WebElement product : products) {
            Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() == 1);
        }
    }
}