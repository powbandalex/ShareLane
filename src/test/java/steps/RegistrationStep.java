package steps;

import io.qameta.allure.Step;
import models.uimodels.LoginModel;
import models.uimodels.RegistrationModel;
import org.openqa.selenium.WebDriver;
import pages.pompages.AccountCreatedPage;
import pages.pompages.RegistrationPomWithStepsMethodsPage;

public class RegistrationStep {

    @Step("Perform registration")
    public LoginModel goThroughRegistration(RegistrationModel registrationModel, WebDriver driver) {
        RegistrationPomWithStepsMethodsPage registrationPage = new RegistrationPomWithStepsMethodsPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.sendRegistrationForm(registrationModel.getZipCode(),
                registrationModel.getFirstName(),
                registrationModel.getLastName(),
                registrationModel.getEmail(),
                registrationModel.getPassword(),
                registrationModel.getConfirmPassword());
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String email = accountCreatedPage.getEmail();
        return new LoginModel(email, "1111");
    }
}
