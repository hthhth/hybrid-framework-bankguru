package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isHomePageSliderDisplayed() {
        waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
        return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
    }

    public RegisterPageObject clickToRegiterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return new RegisterPageObject(driver);
    }

    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return new LoginPageObject(driver);
    }
}
