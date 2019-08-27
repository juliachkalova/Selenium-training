package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.net.URI;
import java.net.URL;
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
        List<WebElement> tabs = driver.findElements(By.cssSelector("ul.index > li"));
        WebElement generalBlock = driver.findElement(By.cssSelector("div#tab-general"));
        generalBlock.findElement(By.xpath("//label[contains(text(),'Enabled')]"));
        generalBlock.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("Duck with children");
        generalBlock.findElement(By.cssSelector("input[name='code']")).sendKeys("123");
        generalBlock.findElement(By.cssSelector("input[name='categories[]'][value='1']")).click();
        generalBlock.findElement(By.cssSelector("input[name='product_groups[]'][value='1-2']")).click();
        generalBlock.findElement(By.cssSelector("input[name='quantity']")).sendKeys("4");
        String workingDir = System.getProperty("user.dir");
        String filepath = workingDir + "/src/test/resources/image-duck.jpg";
        WebElement image = driver.findElement(By.name("new_images[]"));
        image.sendKeys(filepath);
        generalBlock.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("27-08-2019");
        generalBlock.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("27-10-2019");
        tabs.get(1).click();
        Select manufacturer = new Select (driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
        manufacturer.selectByVisibleText("ACME Corp.");
        driver.findElement(By.cssSelector("input[name='keywords']")).sendKeys("Duck");
        driver.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys("Duck with children");
        driver.findElement(By.cssSelector("textarea[name='description[en]']")).sendKeys("Yellow duck with children");
        driver.findElement(By.cssSelector("input[name='head_title[en]']")).sendKeys("Duck with children");
        driver.findElement(By.cssSelector("input[name='meta_description[en]']")).sendKeys("Duck with children");
        tabs.get(3).click();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("15,00");
        Select currency = new Select (driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
        currency.selectByVisibleText("US Dollars");
        driver.findElement(By.cssSelector("input[name='prices[USD]']")).sendKeys("25,00");
        driver.findElement(By.name("save")).click();
        Assert.assertTrue(isElementPresent(driver, By.linkText("Duck with children")));
    }
}
