package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Chrome {
    private Chrome(){}
    private static  WebDriver driver;
    private static Chrome chrome=new Chrome();
    public static void initialize(String path) {
        ChromeOptions options=new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",path);
        options.addArguments("make-default-browser");
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(25000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.MILLISECONDS);
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver d){
        driver=d;
    }
}