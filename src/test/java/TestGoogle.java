
import Contexts.ContextMain;
import Contexts.ContextSearch;
import PageObjects.MainPage;
import Utility.Chrome;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TestGoogle {
    private static String driverPath = "/Users/pashaboyko/Downloads/chromedriver";
    private static Chrome driver;

    @BeforeClass
    public static void setDriver(){

        driver.initialize(driverPath);
        driver.getDriver().manage().timeouts().implicitlyWait(800, MILLISECONDS);
        driver.getDriver().manage().window().maximize();
        driver.getDriver().manage().timeouts().pageLoadTimeout(15, SECONDS);

    }

    @Test
    public void TestSearchOnFirstPage() throws InterruptedException {

            driver.getDriver().navigate().to("https://www.google.com");
            ContextSearch.SearchLink(ContextMain.SearchSmt(new MainPage() , "cats"), Boolean.FALSE,"Film","TestSearchOnFirstPage");
    }


    @Test
    public void TestSearchOnMidle() throws InterruptedException {

        driver.getDriver().navigate().to("https://www.google.com");
        ContextSearch.SearchLink(ContextMain.SearchSmt(new MainPage() , "cats"),Boolean.FALSE, "Cat & Kitten Food","TestSearchOnMidle");


    }

    @Test
    public void TestNoFound() throws InterruptedException {

        driver.getDriver().navigate().to("https://www.google.com");
        ContextSearch.SearchLink(ContextMain.SearchSmt(new MainPage() , "cats676"),Boolean.TRUE, "Bitrix24 -", "TestNoFound");

    }



    @AfterClass
    public static void quitDriver(){
        driver.getDriver().quit();
    }
}