package saleseforceelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownList {

    WebDriver driver;
    String label;
    String dropDownListXpath = "//article[contains(., 'New Account')]//span[contains(., '%s')]/following-sibling::div";
    String optionXpath = "//div[contains(@class, 'uiMenuList') and contains(@class, 'visible')]//li[contains(., '%s')]";

    public DropDownList(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        dropDownListXpath = String.format(dropDownListXpath, label);
        driver.findElement(By.xpath(dropDownListXpath)).click();
        optionXpath = String.format(optionXpath, option);
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
