package pages.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

public class RegistrationClassicalPomPage extends BasePage {

    private By ZIP_INPUT = By.name("zip_code");
    private By CONTINUE_BUTTON = By.cssSelector("[value='Continue']");
    private By FIRST_NAME_INPUT = By.name("first_name");
    private By LAST_NAME_INPUT = By.name("last_name");
    private By EMAIL_INPUT = By.name("email");
    private By PASSWORD_INPUT = By.name("password1");
    private By PASSWORD_CONFIRM_INPUT = By.name("password2");
    private By REGISTER_BUTTON = By.cssSelector("[value='Register']");


    public RegistrationClassicalPomPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        driver.get(WebUrls.SHARE_LANE_REGISTER_URL);
    }

    public void inputIntoZip(String zipcode) {
        driver.findElement(ZIP_INPUT).sendKeys(zipcode);
    }

    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void inputFirstName(String fName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(fName);
    }

    public void inputLastName(String lName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lName);
    }

    public void inputEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void inputPassword(String pwd) {
        driver.findElement(PASSWORD_INPUT).sendKeys(pwd);
    }

    public void inputConfirmPassword(String confirmPwd) {
        driver.findElement(PASSWORD_CONFIRM_INPUT).sendKeys(confirmPwd);
    }

    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }

    public boolean checkRegisterButton() {
        return driver.findElement(REGISTER_BUTTON).isDisplayed();
    }
}
