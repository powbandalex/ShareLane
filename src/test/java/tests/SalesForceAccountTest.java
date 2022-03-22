package tests;

import models.SalesForceAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.salesforcepages.AccountsPage;
import pages.salesforcepages.CreateAccountPage;
import pages.salesforcepages.LoginPage;
import testdata.GetNewAccountModel;
import utilities.PropertiesManager;

public class SalesForceAccountTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SalesForceAccountTest.class.getName());

    @Test
    public void createAccountTest() {
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = System.getenv().getOrDefault("username", propertiesManager.get("USERNAME"));
        String password = System.getenv().getOrDefault("password", propertiesManager.get("PASSWORD"));
        LOGGER.info("'Create account' test started");
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info("Attempt to open " + loginPage.getClass().getName() + " page");
        loginPage.openPage();
        LOGGER.info("Attempt to login with username: " + username + "and password: " + password);
        loginPage.makeLogin(username, password);
        AccountsPage accountsPage = new AccountsPage(driver);
        LOGGER.info("Attempt to open " + accountsPage.getClass().getName() + " page");
        accountsPage.openAccountsTab();
        accountsPage.openCreateAccountModal();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        SalesForceAccountModel salesForceAccountModel = GetNewAccountModel.getAccountWithAllFields();
        LOGGER.info("Attempt to create account with name " + salesForceAccountModel.getAccountName());
        createAccountPage.saveNewAccountForm(salesForceAccountModel);
    }
}
