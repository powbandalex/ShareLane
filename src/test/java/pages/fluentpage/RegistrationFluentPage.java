package pages.fluentpage;

import models.RegistrationModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

public class RegistrationFluentPage extends BasePage {

    private By ZIP_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");
    private By FIRST_NAME_INPUT = By.name("first_name");
    private By LAST_NAME_INPUT = By.name("last_name");
    private By EMAIL_INPUT = By.name("email");
    private By PASSWORD_INPUT = By.name("password1");
    private By PASSWORD_CONFIRM_INPUT = By.name("password2");
    private By REGISTER_BUTTON = By.cssSelector("[value='Register']");


    public RegistrationFluentPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationFluentPage openRegistrationPage() {
        driver.get(WebUrls.SHARE_LANE_REGISTER_URL);
        return this;
    }

    public RegistrationFluentPage inputZipCode(String zipcode) {
        driver.findElement(ZIP_INPUT).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public AccountCreatedPage sendRegistrationForm(RegistrationModel model) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(model.getFirstName());
        driver.findElement(LAST_NAME_INPUT).sendKeys(model.getLastName());
        driver.findElement(EMAIL_INPUT).sendKeys(model.getEmail());
        driver.findElement(PASSWORD_INPUT).sendKeys(model.getPassword());
        driver.findElement(PASSWORD_CONFIRM_INPUT).sendKeys(model.getConfirmPassword());
        driver.findElement(REGISTER_BUTTON).click();
        return new AccountCreatedPage(driver);
    }

    public boolean checkRegisterButton() {
        return driver.findElement(REGISTER_BUTTON).isDisplayed();
    }
}
