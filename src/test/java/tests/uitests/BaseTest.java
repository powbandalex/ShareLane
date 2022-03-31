package tests.uitests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import staticdata.WebTimeouts;
import utilities.TestListeners;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    DriverType driverType;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverType = null;
        if(browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        }
        driverManager = factory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        System.getProperty("configuration");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
