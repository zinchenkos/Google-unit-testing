package Elements;

import org.openqa.selenium.*;

import java.util.Collections;
import java.util.List;

public class element implements WebElement{
    private  WebElement element;

    protected element(WebElement element) {
        this.element=element;
    }

    protected void setElement(WebElement element){
        this.element=element;
    }
    protected WebElement getElement(){
        return element;
    }
    public void click() {
        element.click();
    }

    public void submit() {
        element.submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        element.sendKeys(charSequences);
    }

    public void clear() {
        element.clear();
    }

    public final String getTagName() {
        return element.getTagName();
    }

    public final String getAttribute(String s) {
        return element.getAttribute(s);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public final boolean isEnabled() {
        return element.isEnabled();
    }

    public final String getText() {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        if(this.getClass().equals(element.getClass()))
            return element.findElements(by);
        else
            return Collections.EMPTY_LIST;
    }

    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    public final boolean isDisplayed() {
        return element.isDisplayed();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public final Dimension getSize() {
        return element.getSize();
    }

    public final Rectangle getRect() {
        return element.getRect();
    }

    public final String getCssValue(String s) {
        return element.getCssValue(s);
    }

    public final <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return element.getScreenshotAs(outputType);
    }
}
