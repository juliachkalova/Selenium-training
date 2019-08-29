package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class EditCountries extends BaseTestClass{

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles=driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size()>0 ? handles.iterator().next():null;
            }
        };
    }

    @Test
    public void Test01_EditCountry() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> menus = driver.findElements(By.cssSelector("li#app-"));
        menus.get(2).click();
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=countries&doc=edit_country']")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("form .fa-external-link"));
        Integer linksAmount = links.size();
        for (int i=0; i<linksAmount; i++) {
            String originalWindow = driver.getWindowHandle();
            Set<String> existingWindows = driver.getWindowHandles();
            links.get(i).click();
            String newWindow=wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }
}
