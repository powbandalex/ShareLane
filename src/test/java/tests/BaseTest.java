package tests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import staticdata.WebTimeouts;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
