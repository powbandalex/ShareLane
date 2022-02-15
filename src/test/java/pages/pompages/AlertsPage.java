package pages.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

public class AlertsPage extends BasePage {

    private By JS_ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void openAlertPage() {
        driver.get(WebUrls.ALERTS_URL);
    }

    public void openAlert() {
        driver.findElement(JS_ALERT_BUTTON).click();
    }

    public String getAlertText() {
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }


}
