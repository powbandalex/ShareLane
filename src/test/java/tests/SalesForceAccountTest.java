package tests;

import org.testng.annotations.Test;
import pages.salesforcepages.AccountsPage;
import pages.salesforcepages.LoginPage;

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
        System.out.println("");
    }
}
