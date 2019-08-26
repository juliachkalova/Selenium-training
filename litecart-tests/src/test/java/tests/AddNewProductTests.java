package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewProductTests extends BaseTestClass{

    @Test
    public void Test01_NavigateAllElementsAdminPage() {
        //       this.loginToAdminPage();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> menus = driver.findElements(By.cssSelector("li#app-"));
        menus.get(1).click();
        driver.findElement(By.linkText("Add New Product")).click();
        WebElement generalBlock = driver.findElement(By.cssSelector("div#tab-general"));
        generalBlock.findElement(By.xpath("//label[contains(text(),'Enabled')]"));
        generalBlock.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("Selenium Test Product");
        generalBlock.findElement(By.cssSelector("input[name='code']")).sendKeys("123");
        generalBlock.findElement(By.cssSelector("input[name='categories[]'][value='1']")).click();
        generalBlock.findElement(By.cssSelector("input[name='product_groups[]'][value='1-2']")).click();
        generalBlock.findElement(By.cssSelector("input[name='quantity']")).sendKeys("1");
    }
}
