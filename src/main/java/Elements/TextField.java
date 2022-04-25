package Elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class TextField extends element {
    public TextField(WebElement element) {
        super(element);
    }

    public void selectText() {
        super.sendKeys(Keys.chord(Keys.COMMAND, "x"));
    }

    public void input(String s, boolean i) {
        if (i) {
            sendKeys(s);
        } else {
            clear();
            sendKeys(s);

        }

    }
}