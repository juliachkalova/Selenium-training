package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

public class CampaignsTests extends BaseTestClass {

    public int[] parseColor (String color) {
        String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        System.out.println("r: " + r + " g: " + g + " b: " + b);
        int[] rgb = {r,g,b};
        return rgb;
    }
    @Test
    public void Test01_Verify_Text() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        String nameOfProduct = campaign.findElement(By.cssSelector("div.name")).getText();
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceText = regularPrice.getText();
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceText = campaignPrice.getText();
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        String regularPriceOnProductPageText = reqularPriceOnProductPage.getText();
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        String campaignPriceOnProductPageText = campaignPriceOnProductPage.getText();
        String header = productSection.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(header.equals(nameOfProduct));
        Assert.assertTrue(regularPriceOnProductPageText.equals(regularPriceText));
        Assert.assertTrue(campaignPriceOnProductPageText.equals(campaignPriceText));
    }

    @Test
    public void Test02_Verify_Font_Color() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceColor = regularPrice.getCssValue("color");
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceColor = campaignPrice.getCssValue("color");
        System.out.println(campaignPriceColor);
        int[] campaingColorValues = parseColor(campaignPriceColor);
        Assert.assertTrue((campaingColorValues[0] > 0)&(campaingColorValues[1] == 0)&(campaingColorValues[2] == 0));
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
     }

    @Test
    public void Test03_Verify_Font_Style() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceDecoration = regularPrice.getCssValue("text-decoration-line");
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceFontWeight = campaignPrice.getCssValue("font-weight");
        Assert.assertTrue(regularPriceDecoration.equals("line-through"));
        Assert.assertTrue(campaignPriceFontWeight.equals("700"));
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        String regularPriceOnProductPageDecoration = reqularPriceOnProductPage.getCssValue("text-decoration-line");
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        String campaignPriceOnProductPageFontWeight = campaignPriceOnProductPage.getCssValue("font-weight");
        Assert.assertTrue(regularPriceOnProductPageDecoration.equals("line-through"));
        Assert.assertTrue(campaignPriceOnProductPageFontWeight.equals("700"));
    }
}
