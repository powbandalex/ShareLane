package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.AlertsPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("Web tests")
@Feature("Alerts")
@Story("Implement text on alert")
public class AlertsTest extends BaseTest {

    AlertsPage alertsPage;
    private static final Logger LOGGER = LogManager.getLogger(AlertsTest.class.getName());

    @Test
    @Description("Check if JS alert contains 'I am a JS Alert'")
    @Link("https://instagram.com/")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    @Severity(SeverityLevel.NORMAL)
    public void checkJsAlertTest() throws IOException {
        LOGGER.info("checkJsAlertTest started");
        alertsPage = new AlertsPage(driver);
        alertsPage.openAlertPage();
        alertsPage.openAlert();
        String actualText = alertsPage.getAlertText();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot.png"), sourceFile);
        Assert.assertEquals(actualText, "I am a JS Alert", "Message isn't expected");
    }
}
