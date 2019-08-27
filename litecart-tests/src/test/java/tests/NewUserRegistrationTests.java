package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewUserRegistrationTests extends BaseTestClass {

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @Test
    public void Test01_NewUserRegistration() {
        driver.get("http://localhost/litecart/");
        WebElement newUserButton = driver.findElement(By.cssSelector("div#box-account-login a"));
        newUserButton.click();
        WebElement createAccountSection = driver.findElement(By.cssSelector("div#create-account"));
        // Generate a random email
        final String randomEmail = randomEmail();
        driver.findElement(By.name("firstname")).sendKeys("Julia");
        driver.findElement(By.name("lastname")).sendKeys("Test120");
        driver.findElement(By.name("address1")).sendKeys("Nizhny 60302");
        driver.findElement(By.name("postcode")).sendKeys("60302");
        driver.findElement(By.name("city")).sendKeys("Nizhny");
        WebElement country = createAccountSection.findElement(By.cssSelector("select"));
        Select countryDropdown = new Select (country);
        countryDropdown.selectByVisibleText("United States");
        Select zoneCode = new Select (driver.findElement(By.cssSelector("select[name=zone_code]")));
        zoneCode.selectByVisibleText("New York");
        driver.findElement(By.name("email")).sendKeys(randomEmail);
        driver.findElement(By.name("phone")).sendKeys("1001010");
        driver.findElement(By.name("password")).sendKeys("QwerAsdf");
        driver.findElement(By.name("confirmed_password")).sendKeys("QwerAsdf");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.linkText("Logout")).click();
        WebElement loginForm = driver.findElement(By.cssSelector("form[name=login_form]"));
        loginForm.findElement(By.cssSelector("input[name=email]")).sendKeys(randomEmail);
        loginForm.findElement(By.cssSelector("input[name=password]")).sendKeys("QwerAsdf");
        loginForm.findElement(By.cssSelector("button[name=login]")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
}

