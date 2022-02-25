package tests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import staticdata.WebTimeouts;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.REMOTE);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
