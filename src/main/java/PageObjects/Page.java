package PageObjects;

import Utility.Chrome;
import Utility.Decorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Page {
    public Page(){
        PageFactory.initElements(new Decorator(Chrome.getDriver()),this);
    }

    public boolean screenPage(String numbPage,String testName) {
        JavascriptExecutor js = (JavascriptExecutor) Chrome.getDriver();
        WebElement element1 = Chrome.getDriver().findElement(By.xpath("//div[@id='searchform']"));
        js.executeScript("arguments[0].setAttribute('style', 'visibility: hidden;')",element1);

        Screenshot screenshot=new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Chrome.getDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(testName+"_Page_№" + numbPage +".png"));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean findElementXpath(String key) throws IOException{
        if(Chrome.getDriver().findElements(By.xpath(key)).isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

}
