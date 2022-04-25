package PageObjects;

import Elements.Button;
import Elements.Link;

import Elements.TextField;
import Utility.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends Page {
    @FindBy(name = "q")
    private TextField SearchBar;


    @FindBy(xpath = "//div[@class='tfB0Bf']//input[@name='btnK']")
    private Button Search1;

    @FindBy(xpath = "//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")
    private Button Search2;

    @FindBy(xpath = "//ul[@class='erkvQe']//li")
    private List<Link> SearchList;

    public MainPage(){
        super();
    }

    public MainPage setSearhBar(String searchWord){
        Waiter.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        SearchBar.clear();
        SearchBar.input( new String(searchWord),true);
        return this;
    }

    public SearchPage enterSearh() {
        if (SearchList.isEmpty()){
            Search2.click();
        }
        else Search1.click();
        return new SearchPage();
    }






}
