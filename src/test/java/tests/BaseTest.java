package tests;

import driver.singletondriver.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    ChromeDriverManager chromeDriverManager;

    @BeforeMethod
    public void setUp(){
        chromeDriverManager = ChromeDriverManager.getInstanceOfChromeDriver();
        driver = chromeDriverManager.getDriver();
        chromeDriverManager.maximize();
        chromeDriverManager.setTimeout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        chromeDriverManager.quitDriver();
    }
}
