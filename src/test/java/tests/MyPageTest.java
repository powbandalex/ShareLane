package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import staticdata.WebUrls;


public class MyPageTest extends BaseTest {


    @Test
    public void checkHrefTest() {
        driver.get(WebUrls.LOCAL_PAGE_URL);
        driver.findElement(By.id("href")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Home']")).isDisplayed());
    }

    @Test
    public void checkAlternativeMessageTest() {
        driver.get(WebUrls.LOCAL_PAGE_URL);
        String someString = driver.findElement(By.xpath("//img")).getAttribute("alt");
        Assert.assertEquals(someString, "oops, you found i");
    }

    @Test
    public void alertDemoTest() {
        driver.get(WebUrls.LOCAL_PAGE_URL);
        driver.findElement(By.cssSelector("[onclick]")).click();

    }

    @Test
    public void selectDemoTest() {
        driver.get(WebUrls.LOCAL_PAGE_URL);
        WebElement select = driver.findElement(By.tagName("select"));

    }

    @Test
    public void actionsDemoTest() {
        driver.manage().window().maximize();
        driver.get(WebUrls.LOCAL_PAGE_URL);
        WebElement holdMe = driver.findElement(By.id("column-a"));

    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
