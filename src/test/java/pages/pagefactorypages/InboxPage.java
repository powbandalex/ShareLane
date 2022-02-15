package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {

    @FindBy(xpath = "//body[@class='bodymail yscrollbar']")
    private WebElement mailBody;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailBody() {
        driver.switchTo().frame("ifmail");
        return mailBody.getText();
    }
}
