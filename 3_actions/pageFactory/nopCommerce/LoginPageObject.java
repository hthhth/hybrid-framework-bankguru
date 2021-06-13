package pageFactory.nopCommerce;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(how = How.ID, using = "Email")
    WebElement emailTextbox;

    @FindBy(how = How.XPATH, using = "//input[@id='Password']")
    WebElement passwordTextbox;

    @FindBy(how = How.CLASS_NAME, using = "login-button")
    WebElement loginButton;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        sendKeyToElement(driver, emailTextbox, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendKeyToElement(driver, passwordTextbox, password);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, loginButton);
        clickToElement(driver, loginButton);
    }
}
