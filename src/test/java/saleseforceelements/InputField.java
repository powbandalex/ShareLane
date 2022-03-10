package saleseforceelements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputField {

    WebDriver driver;
    String label;
    String inputXpath = "//article[contains(., 'New Account')]//label[contains(., '%s')]/following-sibling::input";
    private static final Logger LOGGER = LogManager.getLogger(InputField.class.getName());

    public InputField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputText(String text) {
        inputXpath = String.format(inputXpath, label);
        LOGGER.trace(String.format("Fill in %s text into %s field located by %s xpath", text, label, inputXpath));
        driver.findElement(By.xpath(inputXpath)).sendKeys(text);
    }

}
