package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

public class RegistrationPomOnNonSmokerPage extends BasePage {

    private By ZIP_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");
    private By FIRST_NAME_INPUT = By.name("first_name");
    private By LAST_NAME_INPUT = By.name("last_name");
    private By EMAIL_INPUT = By.name("email");
    private By PASSWORD_INPUT = By.name("password1");
    private By PASSWORD_CONFIRM_INPUT = By.name("password2");
    private By REGISTER_BUTTON = By.cssSelector("[value='Register']");


    public RegistrationPomOnNonSmokerPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        driver.get(WebUrls.SHARE_LANE_REGISTER_URL);
    }

    public void inputZipCode(String zipcode) {
        driver.findElement(ZIP_INPUT).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void sendRegistrationForm(String zipcode,
                                     String fName,
                                     String lName,
                                     String email,
                                     String pwd,
                                     String confirmPwd) {
        inputZipCode(zipcode);
        driver.findElement(FIRST_NAME_INPUT).sendKeys(fName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lName);
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(pwd);
        driver.findElement(PASSWORD_CONFIRM_INPUT).sendKeys(confirmPwd);
        driver.findElement(REGISTER_BUTTON).click();
    }

    public boolean checkRegisterButton() {
        return driver.findElement(REGISTER_BUTTON).isDisplayed();
    }
}
