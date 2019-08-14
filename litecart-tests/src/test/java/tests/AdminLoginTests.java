package tests;

import org.junit.After;
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
    }

}
