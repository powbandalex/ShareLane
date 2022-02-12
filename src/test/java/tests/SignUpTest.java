package tests;

import pages.fluentpage.AccountCreatedPage;
import pages.fluentpage.RegistrationFluentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GenerateFakeMessage;

public class SignUpTest extends BaseTest {

    RegistrationFluentPage registrationFluentPage;
    AccountCreatedPage accountCreatedPage;

    @Test
    public void sendFiveDigitsToZipCodeFieldTest() {
        registrationFluentPage = new RegistrationFluentPage(driver);
        registrationFluentPage.openRegistrationPage();
        registrationFluentPage.inputZipCode(GenerateFakeMessage.getValidZipcode());
        boolean isRegisterButtonShown = registrationFluentPage.checkRegisterButton();
        Assert.assertTrue(isRegisterButtonShown, "Error message isn't shown");
    }

    @Test
    public void sendMoreThanFiveDigitsToZipCodeTest() {
        registrationFluentPage = new RegistrationFluentPage(driver);
        registrationFluentPage.openRegistrationPage();
        registrationFluentPage.inputZipCode(GenerateFakeMessage.getSixDigitsZipcode());
        try {
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
            Assert.assertTrue(isErrorMessageShown, "Check Message");
        } catch (NoSuchElementException exception) {
            Assert.fail();
        }
    }

    @Test
    public void sendSignUpFormTest() {
        registrationFluentPage = new RegistrationFluentPage(driver);
        registrationFluentPage.openRegistrationPage();
        registrationFluentPage.inputZipCode(GenerateFakeMessage.getValidZipcode());
        registrationFluentPage.sendRegistrationForm(
                "some",
                "some",
                "some@test.com",
                "string@1",
                "string@1");
        accountCreatedPage = new AccountCreatedPage(driver);
        boolean isSuccessMessageShown = accountCreatedPage.checkConfirmation();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success message isn't shown");
    }
}
