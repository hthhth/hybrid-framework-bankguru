package pageObjects.hrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

}
