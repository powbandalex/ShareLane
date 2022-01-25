import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SignUpTest {

    @Test
    public void sendFiveDigitsToZipCodeFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 6 digits zip;
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the "Continue"
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check Register button is shown
        boolean isRegisterButtonShown = driver.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterButtonShown, "Error message isn't shown");
    }

    @Test
    public void sendMoreThanFiveDigitsToZipCodeTest() throws FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 6 digits zip;
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Click the "Continue"
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        throwsExceptionas("somn");
        try {
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
            Assert.assertTrue(isErrorMessageShown, "Check Message");
        } catch (NoSuchElementException exception) {
            Assert.fail();
        } finally {
            driver.quit();
        }
    }

    public void throwsExceptionas(String path) throws FileNotFoundException {
        BufferedReader rd = new BufferedReader(new FileReader(path));
    }
}
