package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pompages.AlertsPage;

public class AlertsTest extends BaseTest {

    AlertsPage alertsPage;

    @Test
    public void checkJsAlertTest() {
        alertsPage = new AlertsPage(driver);
        alertsPage.openAlertPage();
        alertsPage.openAlert();
        String actualText = alertsPage.getAlertText();
        Assert.assertEquals(actualText, "I am a JS Alert", "Message isn't expected");
    }
}
