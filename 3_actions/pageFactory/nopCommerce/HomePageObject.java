package pageFactory.nopCommerce;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(how = How.ID, using = "nivo-slider")
    WebElement homePageSlider;

    @FindBy(how = How.CLASS_NAME, using = "ico-register")
    WebElement registerLink;

    @FindBy(how = How.CLASS_NAME, using = "ico-login")
    WebElement loginLink;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageSliderDisplayed() {
       waitForElementVisible(driver, homePageSlider);
        return isElementDisplayed(driver, homePageSlider);
    }

    public void clickToRegiterLink() {
        waitForElementVisible(driver, registerLink);
        clickToElement(driver, registerLink);
    }

    public void clickToLoginLink() {
        waitForElementVisible(driver, loginLink);
        clickToElement(driver, loginLink);
    }
}
