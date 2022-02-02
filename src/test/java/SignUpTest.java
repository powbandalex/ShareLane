import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {

    private static final String BASE_URL = "https://www.sharelane.com/cgi-bin/register.py";
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sendFiveDigitsToZipCodeFieldTest() {
        Faker faker = new Faker();

        sendZipCode("123456");
        //Check Register button is shown
        boolean isRegisterButtonShown = driver.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        Assert.assertTrue(isRegisterButtonShown, "Error message isn't shown");
    }

    @Test
    public void sendMoreThanFiveDigitsToZipCodeTest() {
        sendZipCode("123456");
        try {
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
            Assert.assertTrue(isErrorMessageShown, "Check Message");
        } catch (NoSuchElementException exception) {
            Assert.fail();
        }
    }

    @Test
    public void sendSignUpFormTest() {
        sendZipCode("123456");
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Some");
        driver.findElement(By.name("last_name")).sendKeys("Some");
        driver.findElement(By.name("email")).sendKeys("some@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        //Click register button
        driver.findElement(By.cssSelector("[value=Register]")).click();
        //Check message 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success message isn't shown");
    }

    private void sendZipCode(String zipCode) {
        //Open Zip code page
        driver.get(BASE_URL);
        //Input 6 digits zip;
        driver.findElement(By.name("zip_code")).sendKeys(zipCode);
        //Click the "Continue"
        driver.findElement(By.cssSelector("[value=Continue]")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
