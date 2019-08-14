package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

/*
    // явное ожидание появления элемента
    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            wait.until ((WebDriver d) -> d.findElement(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

 */

    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

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
        // настройка неявных ожиданий
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
