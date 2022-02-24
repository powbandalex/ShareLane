package tests;

import org.testng.annotations.Test;
import pages.salesforcepages.AccountsPage;
import pages.salesforcepages.CreateAccountPage;
import pages.salesforcepages.LoginPage;
import testdata.GetNewAccountModel;

public class SalesForceAccountTest extends BaseTest {

    private static String USERNAME = "salesforce-aahd@force.com";
    private static String PASSWORD = "string@1";

    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin(USERNAME, PASSWORD);
        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.openAccountsTab();
        accountsPage.openCreateAccountModal();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.saveNewAccountForm(GetNewAccountModel.getAccountWithAllFields());
        System.out.println("");
    }
}
