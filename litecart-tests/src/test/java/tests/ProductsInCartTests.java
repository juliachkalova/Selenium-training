package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsInCartTests extends BaseTestClass {

    @Test
    public void Test01_ProductsInCart() {
        driver.get("http://localhost/litecart/");
        List<WebElement> products = driver.findElements(By.cssSelector("div#box-most-popular li"));
        for (int i = 0; i < (products.size() - 1); i++) {
            products.get(i).click();
            if (isElementPresent(driver, By.cssSelector("select[name='options[Size]']")) == true) {
                Select size = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
                size.selectByVisibleText("Small");
            }
            WebElement cartCounter = driver.findElement(By.cssSelector("div#cart span.quantity"));
            driver.findElement(By.name("add_cart_product")).click();
            String counter = "" + (i+1);
            wait.until(ExpectedConditions.textToBePresentInElement(cartCounter, counter));
            cartCounter = driver.findElement(By.cssSelector("div#cart span.quantity"));
            driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/']")).click();
            products = driver.findElements(By.cssSelector("div#box-most-popular li"));
        }
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/checkout']")).click();
        for (int i = 0; i < 2; i++) {
            List<WebElement> items = driver.findElements(By.cssSelector("table[class='dataTable rounded-corners'] tr"));
            WebElement removeButton = driver.findElement(By.cssSelector("button[name='remove_cart_item'"));
            removeButton.click();
            wait.until(ExpectedConditions.stalenessOf(items.get(items.size() - 5)));
            items = driver.findElements(By.cssSelector("table[class='dataTable rounded-corners'] tr"));
            removeButton = driver.findElement(By.cssSelector("button[name='remove_cart_item'"));
        }
        WebElement removeButton = driver.findElement(By.cssSelector("button[name='remove_cart_item'"));
        List<WebElement> items = driver.findElements(By.cssSelector("table[class='dataTable rounded-corners'] tr"));
        removeButton.click();
        wait.until(ExpectedConditions.stalenessOf(items.get(items.size() - 5)));
    }
}
