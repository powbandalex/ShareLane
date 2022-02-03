package tests;

import org.openqa.selenium.By;
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


    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
