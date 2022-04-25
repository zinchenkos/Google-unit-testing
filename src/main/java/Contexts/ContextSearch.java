package Contexts;

import PageObjects.SearchPage;

import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class ContextSearch {
    private ContextSearch(){}
    public static void SearchLink(SearchPage page, Boolean screenAllPage,  String contains , String testName)  {
        try {
            assertTrue(screenAllPage ? !page.SearchLink(contains, screenAllPage, testName) : page.SearchLink(contains, screenAllPage, testName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(page.PrintScreen(testName));
    }
}



