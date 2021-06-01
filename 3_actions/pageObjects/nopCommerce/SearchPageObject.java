package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
    WebDriver driver;

    public SearchPageObject(WebDriver driver){
        this.driver = driver;
    }


}
