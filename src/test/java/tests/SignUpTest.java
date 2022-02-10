package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.RegistrationPomOnNonSmokerPage;
import utilities.GenerateFakeMessage;

public class SignUpTest extends BaseTest {

    RegistrationPomOnNonSmokerPage registrationClassicalPomPage;

    @Test
    public void sendFiveDigitsToZipCodeFieldTest() {
        registrationClassicalPomPage = new RegistrationPomOnNonSmokerPage(driver);
        registrationClassicalPomPage.inputZipCode(GenerateFakeMessage.getValidZipcode());
        boolean isRegisterButtonShown = registrationClassicalPomPage.checkRegisterButton();
        Assert.assertTrue(isRegisterButtonShown, "Error message isn't shown");
    }

    @Test
    public void sendMoreThanFiveDigitsToZipCodeTest() {
        registrationClassicalPomPage.inputZipCode(GenerateFakeMessage.getSixDigitsZipcode());
        try {
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
            Assert.assertTrue(isErrorMessageShown, "Check Message");
        } catch (NoSuchElementException exception) {
            Assert.fail();
        }
    }

    @Test
    public void sendSignUpFormTest() {
        registrationClassicalPomPage.sendRegistrationForm(
                GenerateFakeMessage.getValidZipcode(),
                "some",
                "some",
                "some@test.com",
                "string@1",
                "string@1");
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success message isn't shown");
    }
}
