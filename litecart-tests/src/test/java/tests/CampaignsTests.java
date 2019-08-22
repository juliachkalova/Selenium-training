package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

public class CampaignsTests extends BaseTestClass {

    public int[] parseColorChrome (String color) {
        String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        System.out.println("r: " + r + " g: " + g + " b: " + b);
        int[] rgb = {r,g,b};
        return rgb;
    }

    public int[] parseColorFirefox (String color) {
        String[] numbers = color.replace("rgb(", "").replace(")", "").split(",");
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
    public void Test02_Verify_Font_Color_Chrome() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceColor = regularPrice.getCssValue("color");
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceColor = campaignPrice.getCssValue("color");
        int[] campaingColorValues = parseColorChrome(campaignPriceColor);
        int[] regularColorValues = parseColorChrome(regularPriceColor);
        Assert.assertTrue((campaingColorValues[0] > 0)&(campaingColorValues[1] == 0)&(campaingColorValues[2] == 0));
        Assert.assertTrue((regularColorValues[0] == regularColorValues[1])&(regularColorValues[1]== regularColorValues[2]));
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        String regularPriceColorProduct = reqularPriceOnProductPage.getCssValue("color");
        String campaignPriceColorProduct = campaignPriceOnProductPage.getCssValue("color");
        int[] campaingColorValuesProduct = parseColorChrome(campaignPriceColorProduct);
        int[] regularColorValuesProduct = parseColorChrome(regularPriceColorProduct);
        Assert.assertTrue((campaingColorValuesProduct[0] > 0)&(campaingColorValuesProduct[1] == 0)&(campaingColorValuesProduct[2] == 0));
        Assert.assertTrue((regularColorValuesProduct[0] == regularColorValuesProduct[1])&(regularColorValuesProduct[1] == regularColorValuesProduct[2]));
     }

    @Test
    public void Test03_Verify_Font_Color_Firefox_Edge() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceColor = regularPrice.getCssValue("color");
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceColor = campaignPrice.getCssValue("color");
        int[] campaingColorValues = parseColorFirefox(campaignPriceColor);
        int[] regularColorValues = parseColorFirefox(regularPriceColor);
        Assert.assertTrue((campaingColorValues[0] > 0)&(campaingColorValues[1] == 0)&(campaingColorValues[2] == 0));
        Assert.assertTrue((regularColorValues[0] == regularColorValues[1])&(regularColorValues[1]== regularColorValues[2]));
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        String regularPriceColorProduct = reqularPriceOnProductPage.getCssValue("color");
        String campaignPriceColorProduct = campaignPriceOnProductPage.getCssValue("color");
        int[] campaingColorValuesProduct = parseColorFirefox(campaignPriceColorProduct);
        int[] regularColorValuesProduct = parseColorFirefox(regularPriceColorProduct);
        Assert.assertTrue((campaingColorValuesProduct[0] > 0)&(campaingColorValuesProduct[1] == 0)&(campaingColorValuesProduct[2] == 0));
        Assert.assertTrue((regularColorValuesProduct[0] == regularColorValuesProduct[1])&(regularColorValuesProduct[1] == regularColorValuesProduct[2]));
    }

    @Test
    public void Test04_Verify_Font_Style_Chrome_Firefox() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceDecoration = regularPrice.getCssValue("text-decoration-line");
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceFontWeight = campaignPrice.getCssValue("font-weight");
        Integer fontWeight = Integer.valueOf(campaignPriceFontWeight);
        Assert.assertTrue(regularPriceDecoration.equals("line-through"));
        Assert.assertTrue(fontWeight >= 700);;
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        String regularPriceOnProductPageDecoration = reqularPriceOnProductPage.getCssValue("text-decoration-line");
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        String campaignPriceOnProductPageFontWeight = campaignPriceOnProductPage.getCssValue("font-weight");
        Integer fontWeight2 = Integer.valueOf(campaignPriceOnProductPageFontWeight);
        Assert.assertTrue(regularPriceOnProductPageDecoration.equals("line-through"));
        Assert.assertTrue(fontWeight2 >= 700);
    }

    @Test
    public void Test05_Verify_Font_Style_Edge() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        String regularPriceDecoration = regularPrice.getCssValue("text-decoration");
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        String campaignPriceFontWeight = campaignPrice.getCssValue("font-weight");
        Integer fontWeight = Integer.valueOf(campaignPriceFontWeight);
        Assert.assertTrue(regularPriceDecoration.equals("line-through"));
        Assert.assertTrue(fontWeight >= 700);;
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        String regularPriceOnProductPageDecoration = reqularPriceOnProductPage.getCssValue("text-decoration");
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        String campaignPriceOnProductPageFontWeight = campaignPriceOnProductPage.getCssValue("font-weight");
        Integer fontWeight2 = Integer.valueOf(campaignPriceOnProductPageFontWeight);
        Assert.assertTrue(regularPriceOnProductPageDecoration.equals("line-through"));
        Assert.assertTrue(fontWeight2 >= 700);
    }

    @Test
    public void Test06_Verify_Price_Size() {
        driver.get("http://localhost/litecart/");
        WebElement campaign = driver.findElement(By.cssSelector("div#box-campaigns li"));
        WebElement regularPrice = campaign.findElement(By.cssSelector("s.regular-price"));
        Dimension regularPriceSize = regularPrice.getSize();
        WebElement campaignPrice = campaign.findElement(By.cssSelector("strong.campaign-price"));
        Dimension campaignPriceSize = campaignPrice.getSize();
        Assert.assertTrue(campaignPriceSize.width > regularPriceSize.width);
        Assert.assertTrue(campaignPriceSize.height > regularPriceSize.height);
        campaign.click();
        WebElement productSection = driver.findElement(By.cssSelector("div#box-product"));
        WebElement reqularPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper s.regular-price"));
        WebElement campaignPriceOnProductPage = productSection.findElement(By.cssSelector("div.price-wrapper strong.campaign-price"));
        Dimension regularPriceOnProductSize = reqularPriceOnProductPage.getSize();
        Dimension campaignPriceOnProductSize = campaignPriceOnProductPage.getSize();
        Assert.assertTrue(campaignPriceOnProductSize.width > regularPriceOnProductSize.width);
        Assert.assertTrue(campaignPriceOnProductSize.height > regularPriceOnProductSize.height);
    }
}
