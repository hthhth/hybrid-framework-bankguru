package pageObjects.liveGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
    private WebDriver driver;

    public MyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyDashboardHeaderDisplayed() {
        waitForElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER_TEXT);
        return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER_TEXT);
    }
}
