package tests;

import org.testng.annotations.Test;
import pages.pagefactorypages.YopmailLoginPage;

public class YopmailTest extends BaseTest {

    @Test
    public void getMessageFromEmailTest() {
        YopmailLoginPage yopmailLoginPage = new YopmailLoginPage(driver);
        yopmailLoginPage.loginToMail();

    }
}
