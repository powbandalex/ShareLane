package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;

public class LoginTest extends BaseTest {

    private static final String EMAIL = "amit_sidoroff@447.08.sharelane.com";
    private static final String PASSWORD = "1111";

    @Test
    public void loginTest() {
        driver.get(WebUrls.SHARE_LANE_LOGIN_URL);
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        WebElement greeting = driver.findElement(By.className("user"));
        boolean isGreetingDisplayed = greeting.isDisplayed();
        Assert.assertTrue(isGreetingDisplayed);
    }
}
