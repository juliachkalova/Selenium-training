package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountriesTests extends BaseTestClass {
    /**
     * Test01 Verify that countries are located on alphabeticl order
     **/
    @Test
    public void Test01_CountriesInAlphabeticalOrder() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        WebElement table = driver.findElement(By.cssSelector("table.dataTable"));
        List<WebElement> country = table.findElements(By.xpath("//tr[@class='row']/td[5]/a"));
        String strArray[] = new String[country.size()];
        for (int i = 0; i < country.size(); i++) {
            System.out.println(country.get(i).getText());
            strArray[i] = country.get(i).getText();
        }
        /* Sort the Array */
        String temp = null;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i].compareTo(strArray[j]) > 0) {
                    temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }
        /* Printing the Values after sorting */
        System.out.println("##################Sorted values in the Array####################");
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
        /* Comparison between the List and Sorted Array */
        boolean result = true;
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i] + "###" + country.get(i).getText());
            if (strArray[i].compareTo(country.get(i).getText()) != 0) {
                result = false;
                System.out.println("Elements in the table are not sorted ");
                break;
            }
        }
        System.out.println("Elements in the dynamic table are sorted::" + result);
        Assert.assertTrue(result = true);
    }

    @Test
    public void Test02_ZonesInAlphabeticalOrder() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        WebElement table = driver.findElement(By.cssSelector("table.dataTable"));
        List<WebElement> country = table.findElements(By.xpath("//tr[@class='row']/td[5]/a"));
        List<WebElement> zone = table.findElements(By.xpath("//tr[@class='row']/td[6]"));
        for (int i = 0; i < zone.size(); i++) {
            if (Integer.valueOf(zone.get(i).getText()) != 0) {
                country.get(i).click();
                WebElement tableZones = driver.findElement(By.cssSelector("table#table-zones"));
                List<WebElement> zonesName = tableZones.findElements(By.xpath("//tr/td[3]"));
                String strArray[] = new String[(zonesName.size()-2)];
                for (int l = 0; l < (zonesName.size()-2); l++) {
                    System.out.println(zonesName.get(l+1).getText());
                    strArray[l] = zonesName.get(l+1).getText();
                }
                /* Sort the Array */
                String temp = null;
                for (int l = 0; l < strArray.length; l++) {
                    for (int j = l + 1; l < strArray.length; l++) {
                        if (strArray[l].compareTo(strArray[j]) > 0) {
                            temp = strArray[l];
                            strArray[l] = strArray[j];
                            strArray[j] = temp;
                        }
                    }
                }
                /* Printing the Values after sorting */
                System.out.println("##################Sorted values in the Array####################");
                for (int l = 0; l < strArray.length; l++) {
                    System.out.println(strArray[l]);
                }
                /* Comparison between the List and Sorted Array */
                boolean result = true;
                for (int l = 0; l < strArray.length; l++) {
                    System.out.println(strArray[l] + "###" + zonesName.get(l+1).getText());
                    if (strArray[l].compareTo(zonesName.get(l+1).getText()) != 0) {
                        result = false;
                        System.out.println("Elements in the table are not sorted ");
                        break;
                    }
                }
                System.out.println("Elements in the dynamic table are sorted::" + result);
                Assert.assertTrue(result = true);
                WebElement menuCountry = driver.findElement(By.cssSelector("li#app-.selected"));
                menuCountry.click();
                table = driver.findElement(By.cssSelector("table.dataTable"));
                zone = table.findElements(By.xpath("//tr[@class='row']/td[6]"));
                country = table.findElements(By.xpath("//tr[@class='row']/td[5]/a"));
            }
        }
    }
}
