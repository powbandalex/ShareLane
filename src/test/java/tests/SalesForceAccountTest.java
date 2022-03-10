package tests;

import models.SalesForceAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.salesforcepages.AccountsPage;
import pages.salesforcepages.CreateAccountPage;
import pages.salesforcepages.LoginPage;
import testdata.GetNewAccountModel;

public class SalesForceAccountTest extends BaseTest {

    private static String USERNAME = "salesforce-aahd@force.com";
    private static String PASSWORD = "string@1";
    private static final Logger LOGGER = LogManager.getLogger(SalesForceAccountTest.class.getName());

    @Test
    public void createAccountTest() {
        LOGGER.info("'Create account' test started");
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info("Attempt to open " + loginPage.getClass().getName() + " page");
        loginPage.openPage();
        LOGGER.info("Attempt to login with username: " + USERNAME + "and password: " + PASSWORD);
        loginPage.makeLogin(USERNAME, PASSWORD);
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
