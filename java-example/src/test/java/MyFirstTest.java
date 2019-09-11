import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;


    //String projectLocation = System.getProperty("user.dir");
    //String driverLocation = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Михаил\\IdeaProjects\\Selenium\\lib\\chromedriver\\chromedriver.exe");
    @Before
    public void start() {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void MyFirstTest() {
        driver.get("http://www.mail.ru/");
       // wait.until(titleIs("webdriver - Search in Google"));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;

    }
}
