package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountriesTests extends BaseTestClass{
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
        for(int i =0; i<country.size(); i++)
        {
            System.out.println(country.get(i).getText());
            strArray[i]=country.get(i).getText();
        }
        /* Sort the Array */
        String temp = null;
        for (int i = 0; i < strArray.length; i++)
        {
            for (int j = i + 1; j < strArray.length; j++)
            {
                if (strArray[i].compareTo(strArray[j])>0)
                {
                    temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }
        /* Printing the Values after sorting */
        System.out.println("##################Sorted values in the Array####################");
        for (int i = 0; i < strArray.length; i++)
        {
            System.out.println(strArray[i]);
        }
        /* Comparison between the List and Sorted Array */
        boolean result = true;
        for(int i =0;i<strArray.length;i++)
        {
            System.out.println(strArray[i]+"###"+country.get(i).getText());
            if(strArray[i].compareTo(country.get(i).getText())!=0)
            {
                result = false;
                System.out.println("Elements in the table are not sorted ");
                break;
            }
        }
        System.out.println("Elements in the dynamic table are sorted::"+ result);
        Assert.assertTrue(result=true);
    }
}
