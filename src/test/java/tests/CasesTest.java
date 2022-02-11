package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CasesTest extends BaseTest {

    @Test
    public void loginSauceTest() {
        driver.get("https://www.saucedemo.com/");
        WebElement sre = driver.findElement(By.id("login_credentials"));
        String[] removeBr = sre.getAttribute("innerHTML").split("<br>");
        String[] removeH = removeBr[0].split("</h4>");
        String neededText = removeH[1];
        System.out.println(neededText);
    }

    @Test
    public void findElementInFindElementTest() {
        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> trs = driver.findElements(By.xpath("//*[@id='table2']//tr"));
        String dues = "";
        String website = "";
        for (WebElement element : trs) {
            String email = element.findElement(By.className("email")).getText();
            if (email.equals("fbach@yahoo.com")) {
                dues = element.findElement(By.className("dues")).getText();
                website = element.findElement(By.className("web-site")).getText();
            }
        }
        Assert.assertEquals(dues, "$51.00", "Expected due wasn't found");
        Assert.assertEquals(website, "http://www.frank.com", "Expected due wasn't found");
    }

    @Test
    public void containsTest() {
        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> trs = driver.findElements(By.xpath("//*[@id='table2']//tr"));
        String fullString = "";
        for (WebElement element : trs) {
            fullString = element.getText();
            if (fullString.contains("fbach@yahoo.com")) {
                break;
            }
        }
        Assert.assertTrue(fullString.contains("$51.00"), "Expected due wasn't found");
        Assert.assertTrue(fullString.contains("http://www.frank.com"), "Expected due wasn't found");
    }

    @Test
    public void notificationMessageTest() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[text() = 'Click here']")).click();
        String actualAlertMessage = driver.findElement(By.id("flash")).getText();
        String expectedAlertMessage = "Action successful";
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Messages are not equal");
    }

    @Test
    public void checkValueOfButtonsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text() = 'Add Element']")).click();
        driver.findElement(By.xpath("//button[text() = 'Add Element']")).click();

        driver.findElement(By.className("added-manually")).click();

        String numberOfButtons = driver.findElement(By.id("elements")).getAttribute("childElementCount");
        Assert.assertEquals(numberOfButtons, "1");

    }
}
