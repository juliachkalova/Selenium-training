package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginTests extends BaseTestClass {

/*    // Locators
    String baseURL = "http://localhost/litecart/admin";
    public WebElement usernameEnterField = driver.findElement(By.name("username"));
    public WebElement passwordEnterField = driver.findElement(By.name("password"));
    public WebElement loginButton = driver.findElement(By.name("login"));


    //Actions
    public void openBaseURL () {
        driver.get(baseURL);
    }

    public void loginToAdminPage () {
        openBaseURL();
        usernameEnterField.sendKeys("admin");
        passwordEnterField.sendKeys("admin");
        loginButton.click();
    }


 */
    /**Test01 Navigate through all elements on Admin page  **/
    @Test
    public void Test01_NavigateAllElementsAdminPage() {
 //       this.loginToAdminPage();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Appearence')]")).click();
        driver.findElement(By.id("doc-template")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Template')]")));
        driver.findElement(By.id("doc-logotype")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Logotype')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Catalog')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Catalog')]")));
        driver.findElement(By.id("doc-product_groups")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Product Groups')]")));
        driver.findElement(By.id("doc-option_groups")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Option Groups')]")));
        driver.findElement(By.id("doc-manufacturers")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Manufacturers')]")));
        driver.findElement(By.id("doc-suppliers")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Suppliers')]")));
        driver.findElement(By.id("doc-delivery_statuses")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Delivery Statuses')]")));
        driver.findElement(By.id("doc-sold_out_statuses")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Sold Out Statuses')]")));
        driver.findElement(By.id("doc-quantity_units")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Quantity Units')]")));
        driver.findElement(By.id("doc-csv")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'CSV Import/Export')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Countries')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Countries')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Currencies')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Currencies')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Customers')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Customers')]")));
        driver.findElement(By.id("doc-csv")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'CSV Import/Export')]")));
        driver.findElement(By.id("doc-newsletter")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Newsletter')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Geo Zones')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Geo Zones')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Languages')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Languages')]")));
        driver.findElement(By.id("doc-storage_encoding")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Storage Encoding')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Modules')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Job Modules')]")));
        driver.findElement(By.id("doc-customer")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Customer Modules')]")));
        driver.findElement(By.id("doc-shipping")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Shipping Modules')]")));
        driver.findElement(By.id("doc-payment")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Payment Modules')]")));
        driver.findElement(By.id("doc-order_total")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Order Total Modules')]")));
        driver.findElement(By.id("doc-order_success")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Order Success Modules')]")));
        driver.findElement(By.id("doc-order_action")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Order Action Modules')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Orders')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Orders')]")));
        driver.findElement(By.id("doc-order_statuses")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Order Statuses')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Pages')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Pages')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Reports')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Monthly Sales')]")));
        driver.findElement(By.id("doc-most_sold_products")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Most Sold Products')]")));
        driver.findElement(By.id("doc-most_shopping_customers")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Most Shopping Customers')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Settings')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-defaults")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-general")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-listings")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-images")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-checkout")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-advanced")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.id("doc-security")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Settings')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Slides')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Slides')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Tax')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Tax Classes')]")));
        driver.findElement(By.id("doc-tax_rates")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Tax Rates')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Translations')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Search Translations')]")));
        driver.findElement(By.id("doc-scan")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Scan Files For Translations')]")));
        driver.findElement(By.id("doc-csv")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'CSV Import/Export')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'Users')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'Users')]")));
        driver.findElement(By.xpath("//span[contains(@class,'name')] [contains(text(),'vQmods')]")).click();
        Assert.assertTrue(isElementPresent(driver, By.xpath("//h1[contains(text(),'vQmods')]")));
    }

}
