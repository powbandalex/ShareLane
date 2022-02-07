package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;

public class LoginTest extends BaseTest {

    private static final String EMAIL = "";
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
