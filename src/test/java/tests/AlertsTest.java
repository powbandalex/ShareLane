package tests;

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

public class AlertsTest extends BaseTest {

    AlertsPage alertsPage;
    private static final Logger LOGGER = LogManager.getLogger(AlertsTest.class.getName());

    @Test()
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
