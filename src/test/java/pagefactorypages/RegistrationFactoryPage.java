package pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import staticdata.WebUrls;

public class RegistrationFactoryPage extends BasePage {

    @FindBy(name = "zip_code")
    private WebElement zipInput;

    @FindBy(css = "[value='Continue']")
    private WebElement continueButton;

    @FindBy(name = "first_name")
    private WebElement firstNameInput;

    @FindBy(name = "last_name")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password1")
    private WebElement passwordInput;

    @FindBy(name = "password2")
    private WebElement confirmPasswordInput;

    @FindBy(css = "[value='Register']")
    private WebElement registerButton;


    public RegistrationFactoryPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        driver.get(WebUrls.SHARE_LANE_REGISTER_URL);
    }

    public void inputZipCode(String zipcode) {
        zipInput.sendKeys(zipcode);
        continueButton.click();
    }

    public void sendRegistrationForm(String zipcode,
                                     String fName,
                                     String lName,
                                     String email,
                                     String pwd,
                                     String confirmPwd) {
        inputZipCode(zipcode);
        firstNameInput.sendKeys(fName);
        lastNameInput.sendKeys(lName);
        emailInput.sendKeys(email);
        firstNameInput.sendKeys(pwd);
        confirmPasswordInput.sendKeys(confirmPwd);
        registerButton.click();
    }

    public boolean checkRegisterButton() {
        return registerButton.isDisplayed();
    }
}
