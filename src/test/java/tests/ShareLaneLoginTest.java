package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;

public class ShareLaneLoginTest extends BaseTest {

    private static final String EMAIL = "linda_holmes@349.05.sharelane.com";
    private static final String PASSWORD = "1111";

    @Test
    public void loginTest() {
        driver.get(WebUrls.SHARE_LANE_LOGIN_URL);
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("[value='Login']")));
        chromeDriverManager.removeTimeout();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user")));
        chromeDriverManager.setTimeout();
        WebElement greeting = driver.findElement(By.className("user"));
        boolean isGreetingDisplayed = greeting.isDisplayed();
        Assert.assertTrue(isGreetingDisplayed);
    }
}
