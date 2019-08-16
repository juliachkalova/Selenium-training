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

import java.util.List;

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

    /**
     * Test01 Navigate through all elements on Admin page
     **/
 /*   @Test
    public void Test01_NavigateAllElementsAdminPage() {
        //       this.loginToAdminPage();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> menus = driver.findElements(By.cssSelector("li#app-"));
        WebElement menu = driver.findElement(By.cssSelector("li#app-"));
        for (int i = 1; i <= menus.size(); i++) {
            menu.click();
            Assert.assertTrue(isElementPresent(driver, By.tagName("h1")));
            WebElement submenu = driver.findElement(By.cssSelector("span.name"));
            int countSubMenu = driver.findElements(By.cssSelector("span.name")).size();
            /* if (countSubMenu > 1) {
                for (int y=1; y<=countSubMenu; y++) {
                    submenu.click();
                    Assert.assertTrue(isElementPresent(driver, By.tagName("h1")));
                    submenu = driver.findElement(By.cssSelector("span.name"));
                }


            String selectorMenu = "//li(@id='app-' :" + i + 1 + "th child()";
            menu = driver.findElement(By.xpath(selectorMenu));
        }
    }

  */

    @Test
    public void Test01_NavigateAllElementsAdminPage() {
        //       this.loginToAdminPage();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        WebElement sideMenu = driver.findElement(By.id("box-apps-menu"));
        List<WebElement> menus = sideMenu.findElements(By.cssSelector("li#app-"));
        WebElement menu = driver.findElement(By.cssSelector("li#app-"));
        for (int i = 1; i <= menus.size(); i++) {
            menu.click();
            Assert.assertTrue(isElementPresent(driver, By.tagName("h1")));
            WebElement submenu = driver.findElement(By.cssSelector("span.name"));
            int countSubMenu = driver.findElements(By.cssSelector("span.name")).size();
            /* if (countSubMenu > 1) {
                for (int y=1; y<=countSubMenu; y++) {
                    submenu.click();
                    Assert.assertTrue(isElementPresent(driver, By.tagName("h1")));
                    submenu = driver.findElement(By.cssSelector("span.name"));
                }

             */
            String selectorMenu = "//li(@id='app-' :" + i + 1 + "th child()";
            menu = driver.findElement(By.xpath(selectorMenu));
        }
    }

}