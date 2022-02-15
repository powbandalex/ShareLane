package pages.loadablecomponentpage;

import org.openqa.selenium.WebDriver;

abstract class BasePage {

    WebDriver driver;

    public abstract boolean isElementExist();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
