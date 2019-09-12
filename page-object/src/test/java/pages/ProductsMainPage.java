package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsMainPage extends Page {

    public ProductsMainPage(WebDriver driver) {
        super(driver);
    }

    public ProductsMainPage open() {
        driver.get("http://localhost/litecart/");
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.id("box-most-popular")).size() > 0;
    }

    @FindBy(css = "div#box-most-popular li")
    private List<WebElement> products;

    public void openProduct() {
        for (int i = 0; i < (products.size() - 1); i++) {
            products.get(i).click();
            WebElement cartCounter = driver.findElement(By.cssSelector("div#cart span.quantity"));
            driver.findElement(By.name("add_cart_product")).click();
            String counter = "" + (i+1);
            wait.until(ExpectedConditions.textToBePresentInElement(cartCounter, counter));
            cartCounter = driver.findElement(By.cssSelector("div#cart span.quantity"));
            driver.findElement(By.xpath("//a[@href='http://localhost/litecart/en/']")).click();
            products = driver.findElements(By.cssSelector("div#box-most-popular li"));
        }

    }


}
