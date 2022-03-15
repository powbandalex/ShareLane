package pages.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private By emailText = By.xpath("//td[text()='Email']/following-sibling::td");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getEmail() {
        return driver.findElement(emailText).getText();
    }
}
