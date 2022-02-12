package pages.fluentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private By CONFIRMATION_MESSAGE = By.className("confirmation_message");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkConfirmation() {
        return driver.findElement(CONFIRMATION_MESSAGE).isDisplayed();
    }
}
