package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CampaignsTests extends BaseTestClass {
     /**
     * Test01 Find stickers and verify that each product has only one sticker
     **/
    @Test
    public void Test01_OnlyOneStickerPerProduct() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        String nameOfProduct = campaign.findElement(By.cssSelector("div.name")).getText();
        campaign.click();
        WebElement productSection =driver.findElement(By.cssSelector("div#box-product"));
        String header = productSection.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(header.equals(nameOfProduct));
    }
}
