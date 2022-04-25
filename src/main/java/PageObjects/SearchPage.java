package PageObjects;

import Elements.*;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;





public class SearchPage extends Page {

    final private String xpathNextPage="//a[@id='pnnext']";
    @FindBy(xpath = xpathNextPage )
    private Link NextPage;

    @FindBy(xpath = "//td[@class='cur']" )
    private Td NumberPge;


   public boolean SearchLink(String contains , boolean screenAllPage, String testName) throws IOException
   {
       String xpathLinks= "//div[@class='srg']//a[contains(h3,'" + contains+ "')]";
       while (!findElementXpath(xpathLinks))
       {
           if (screenAllPage) screenPage(NumberPge.getText(), testName);
           NextPage.click();
           if (!findElementXpath(xpathNextPage)){
               return false;
           }
       }
       return true;
   }


    public boolean PrintScreen(String testName){
        return screenPage(NumberPge.getText() , testName);
    }


}
