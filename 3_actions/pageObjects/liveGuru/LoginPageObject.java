package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public void loginToSystem(String emailAddress, String password){
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
    }

    public String getEmptyEmailErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
    }

    public String getEmptyPasswordErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
    }

    public String getInvalidEmailErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
    }

    public String getInvalidPasswordErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
    }

    public String getInvalidEmailOrPasswordErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
    }
}
