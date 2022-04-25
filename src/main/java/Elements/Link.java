
package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Link extends element {
    public Link (WebElement element){
        super(element);
    }
    public void follow(){
        if(super.isEnabled())
            click();
    }
    public void waitUntilAppear(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}