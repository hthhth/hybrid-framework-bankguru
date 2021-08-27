package pageObjects.user.nopCommerce;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click to Gender Male radio")
    public void clickToGenderMaleRadioButton() {
        waitForElementVisible(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to Firstname textbox with value {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter to Lastname textbox with value {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter to Email textbox with value {0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Password textbox with value {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox with value {0}")
    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassword);
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Verify success message displayed")
    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
    }

    @Step("Click to Logout link")
    public HomePageObject clickToLogoutLink() {
        waitForElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePage(driver);
    }


}
