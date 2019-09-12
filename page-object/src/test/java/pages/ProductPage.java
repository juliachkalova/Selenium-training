package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page {

    public ProductsMainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.cssSelector("#box-product.box")).size() > 0;
    }

    public void selectSize(String size) {
        if (isElementPresent(driver, By.cssSelector("select[name='options[Size]']")) == true) {
            new Select(driver.findElement(By.cssSelector("select[name='options[Size]']"))).selectByVisibleText(size);
        }
    }
}
