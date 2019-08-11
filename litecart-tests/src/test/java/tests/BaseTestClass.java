package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**Base Class for all types of tests.
 Attention! There are the following methods that should be overridden in descendant classes if they require
 behaviour differed from the one of base class. **/

public class BaseTestClass {

    /*

    // 1. Parallel launchin several threads
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }

        driver = new ChromeDriver();
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null; }));
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
    }
     */

    /*
    2.* // Launch with closing browser after each test case
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        // driver = new EdgeDriver();
        // WebDriver chromeDriver = new ChromeDriver();
        // WebDriver ieDriver = new InternetExplorerDriver();
        // WebDriver firefoxDriver = new FirefoxDriver();

        // Launch Firefox via old method without geckodriver
        FirefoxOptions options = new FirefoxOptions().setLegacy(true);
        driver = new FirefoxDriver(options);


        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
*/
    //3.  Launch without closing browser after each test case
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        // driver = new EdgeDriver();
        // WebDriver chromeDriver = new ChromeDriver();
        // WebDriver ieDriver = new InternetExplorerDriver();
        // WebDriver firefoxDriver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);
        Runtime.getRuntime().addShutdownHook(
            new Thread(() -> {driver.quit(); driver = null; }));
    }

    @After
    public void stop(){
        // driver.quit();
        // driver = null;
    }
}
