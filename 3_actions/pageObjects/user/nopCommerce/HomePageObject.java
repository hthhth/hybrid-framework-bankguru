package pageObjects.user.nopCommerce;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public String getDriver(){
        return driver.toString();
    }

    @Step("Verify Home page slider is displayed")
    public boolean isHomePageSliderDisplayed() {
        waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
        return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
    }

    @Step("Click to Register link")
    public RegisterPageObject clickToRegiterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    @Step("Click to Login link")
    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }

}
