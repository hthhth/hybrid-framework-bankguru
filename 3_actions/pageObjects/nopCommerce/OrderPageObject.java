package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.OrderPageUI;

public class OrderPageObject extends BasePage {
    WebDriver driver;

    public OrderPageObject(WebDriver driver){
        this.driver = driver;
    }


}
