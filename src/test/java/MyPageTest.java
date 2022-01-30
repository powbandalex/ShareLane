import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Start Driver");
    }

    @Test
    public void checkHrefTest() {
        driver.get("file:///C:/ShareLane/src/main/resources/about.html");
        driver.findElement(By.id("href")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Home']")).isDisplayed());
    }

    @Test
    public void checkAlternativeMessageTest() {
        driver.get("file:///C:/ShareLane/src/main/resources/about.html");
        String someString = driver.findElement(By.xpath("//img")).getAttribute("alt");
        Assert.assertEquals(someString, "oops, you found i");
    }


    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
