package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMyAccountFooterLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_FOOTER);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_FOOTER);
    }
}
