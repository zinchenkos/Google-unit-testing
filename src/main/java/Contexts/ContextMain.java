package Contexts;


import PageObjects.MainPage;
import PageObjects.SearchPage;


public class ContextMain {
    private ContextMain(){}
    public static SearchPage SearchSmt(MainPage mainpage, String smt) throws InterruptedException {
        mainpage=mainpage.setSearhBar(smt);
        Thread.sleep(200);

        return mainpage.enterSearh() ;

    }
}

