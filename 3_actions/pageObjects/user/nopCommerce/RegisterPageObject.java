package pageObjects.user.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToGenderMaleRadioButton() {
        waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }


}
