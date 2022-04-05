package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TMSSteps {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User is on main screen")
    public void userIsOnMainScreen() {
        driver.get("https://teachmeskills.by/");
    }

    @When("User clicks {string} tab")
    public void userClicksTab(String tabName) {
        String tabButtonXpath = String.format("//div[@data-menu]//a[text()='%s']", tabName);
        driver.findElement(By.xpath(tabButtonXpath)).click();
    }

    @And("User click {string} button")
    public void userClickButton(String buttonName) {
        String buttonXpath = String.format("//div[contains(@class, 'animated-btn')]//div[contains(., '%s')]", buttonName);
        driver.findElement(By.xpath(buttonXpath)).click();
    }

    @Then("{string} option presents and is first in the list")
    public void optionPresentsAndIsFirstInTheList(String arg0) {
    }
}
