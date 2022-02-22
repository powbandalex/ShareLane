package elements;

import org.openqa.selenium.WebElement;

public class TextFieldImpl implements TextInput{

    protected final WebElement wrappedElement;

    protected TextFieldImpl(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public void write(String text) {
        wrappedElement.sendKeys(text);
    }

    @Override
    public void clearAndWrite(String text) {
        clear();
        write(text);
    }
}
