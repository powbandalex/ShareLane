package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;


public class LocalPageTest extends BaseTest {

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
        WebElement selectElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        System.out.println(select.getOptions().get(1).getText());

    }

    @Test
    public void actionsDemoTest() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(elementA)
                .clickAndHold(elementA)
                .moveToElement(elementB)
                .release()
                .build()
                .perform();
    }
}
