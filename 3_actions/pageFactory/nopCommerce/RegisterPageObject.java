package pageFactory.nopCommerce;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(how = How.ID, using = "gender-male")
    WebElement genderMailRadio;
    @FindBy(how = How.ID, using = "FirstName")
    WebElement firstNameTextbox;
    @FindBy(how = How.ID, using = "LastName")
    WebElement lastNameTextbox;
    @FindBy(how = How.ID, using = "Email")
    WebElement emailTextbox;
    @FindBy(how = How.ID, using = "Password")
    WebElement passwordTextbox;
    @FindBy(how = How.ID, using = "ConfirmPassword")
    WebElement confirmTextbox;
    @FindBy(how = How.ID, using = "register-button")
    WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//div[@class='result' and text()='Your registration completed']")
    WebElement successMessage;
    @FindBy(how = How.XPATH, using = "//a[@class='ico-logout' and text()='Log out']")
    WebElement logoutLink;

    public RegisterPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToGenderMaleRadioButton() {
        waitForElementVisible(driver, genderMailRadio);
        clickToElement(driver, genderMailRadio);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        sendKeyToElement(driver, firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendKeyToElement(driver, lastNameTextbox, lastName);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        sendKeyToElement(driver, emailTextbox, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendKeyToElement(driver, passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, confirmTextbox);
        sendKeyToElement(driver, confirmTextbox, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, successMessage);
        return isElementDisplayed(driver, successMessage);
    }

    public void clickToLogoutLink() {
        waitForElementVisible(driver, logoutLink);
        clickToElement(driver, logoutLink);
    }
}
