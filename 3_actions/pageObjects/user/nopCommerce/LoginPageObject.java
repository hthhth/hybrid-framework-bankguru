package pageObjects.user.nopCommerce;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    @Step("Enter to Email textbox with value {0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Password textbox with value {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }

    public HomePageObject openHomePage(WebDriver driver) {
//        waitForElementClickable(driver, LoginPageUI.HOMEPAGE_IMG);
//        clickToElement(driver, LoginPageUI.HOMEPAGE_IMG);
        waitForElementClickable(driver, "//img[@alt='nopCommerce demo store']");
        clickToElement(driver, "//img[@alt='nopCommerce demo store']");
        return PageGeneratorManager.getHomePage(driver);
    }
}
