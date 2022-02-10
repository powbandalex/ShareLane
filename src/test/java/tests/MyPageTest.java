package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;


public class MyPageTest extends BaseTest {

    @Test
    public void cookiesDemo() {
        driver.get("https://www.onliner.by/");
        System.out.println(driver.manage().getCookies());
        System.out.println(driver.manage().getCookies());
        Cookie cookie = driver.manage().getCookieNamed("ouid");
        driver.manage().addCookie(cookie);
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies());
    }


    @Test
    public void getUrlDemoTest() {
        driver.navigate().to(WebUrls.LOCAL_PAGE_URL);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.navigate().to(WebUrls.LOCAL_PAGE_URL);
        driver.navigate().refresh();
        System.out.println(driver.getWindowHandle());

    }

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
        WebElement holdMeImOnFire = driver.findElement(By.id("column-a"));

    }
}
