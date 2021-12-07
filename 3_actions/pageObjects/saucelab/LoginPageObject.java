package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {
        waitForAllElementsVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForAllElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public InventoryPageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getInventoryPage(driver);
    }
}
