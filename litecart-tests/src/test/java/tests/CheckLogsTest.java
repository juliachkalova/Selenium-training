package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.lang.reflect.Array;
import java.util.List;

public class CheckLogsTest extends BaseTestClass {

    @Test
    public void Test01_CheckBrowserLogs() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        WebElement catalogForm = driver.findElement(By.cssSelector("form[name='catalog_form']"));
        WebElement table = catalogForm.findElement(By.className("dataTable"));
        List<WebElement> rows = table.findElements(By.xpath("//td/img/following-sibling::a"));
        for (int i = 0; i < (rows.size()-1); i++) {
            rows.get(i).click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println(l);
            }
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            catalogForm = driver.findElement(By.cssSelector("form[name='catalog_form']"));
            table = catalogForm.findElement(By.className("dataTable"));
            rows = table.findElements(By.xpath("//td/img/following-sibling::a"));
        }
    }
}
