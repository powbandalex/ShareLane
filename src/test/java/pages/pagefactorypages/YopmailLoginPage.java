package pages.pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import staticdata.WebUrls;

public class YopmailLoginPage extends BasePage {

    private final static String EMAIL = "salesforce";

    @FindBy(xpath = "//*[@id='login']")
    private WebElement yopmailEmail;

    public YopmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToMail() {
        driver.get(WebUrls.YOPMAIL_URL);
        yopmailEmail.click();
        yopmailEmail.sendKeys(EMAIL);
        yopmailEmail.submit();
    }
}
