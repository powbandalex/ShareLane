package driver.singletondriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import staticdata.WebTimeouts;
import utilities.PropertiesManager;

import java.util.concurrent.TimeUnit;

public class ChromeDriverManager {

    private static ChromeDriverManager instanceOfChromeDriver;
    private WebDriver driver;

    private ChromeDriverManager() {
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver", propertiesManager.get("PATH_TO_CHROME_DRIVER"));
        driver = new ChromeDriver();
    }

    public static ChromeDriverManager getInstanceOfChromeDriver() {
        if (instanceOfChromeDriver == null) {
            instanceOfChromeDriver = new ChromeDriverManager();
        }
        return instanceOfChromeDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setTimeout() {
        driver.manage().timeouts().setScriptTimeout(WebTimeouts.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WebTimeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WebTimeouts.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
    }

}
