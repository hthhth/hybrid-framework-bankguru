package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePageFactory {
    public static BasePage getBasePage(){
        return new BasePage();
    }

    public void openPageURL(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }

    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getPageURL(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }

    public Alert waitForAlertPresence(WebDriver driver){
        explicitWait = new WebDriverWait(driver, timeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        alert = waitForAlertPresence(driver);
        alert.accept();
    }

    public void cancelAlert(WebDriver driver){
        alert = waitForAlertPresence(driver);
        alert.dismiss();
    }

    public void sendKeyToAlert(WebDriver driver, String value){
        alert = waitForAlertPresence(driver);
        alert.sendKeys(value);
    }

    public String getAlertText(WebDriver driver){
        alert = waitForAlertPresence(driver);
        return alert.getText();
    }

    public void switchToWindowByID(WebDriver driver, String parentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String windowID : allWindowIDs) {
            if (!windowID.equals(parentID)){
                driver.switchTo().window(windowID);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String windowID : allWindowIDs){
            driver.switchTo().window(windowID);
            String windowTitle = driver.getTitle();
            if (windowTitle.equals(expectedWindowTitle)){
                break;
            }
        }
    }

    public void closeAllWindowExceptParent(WebDriver driver, String parentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String windowID : allWindowIDs) {
            if (!windowID.equals(parentID)) {
                driver.switchTo().window(windowID);
                driver.close();
                sleepInSeconds(1);
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSeconds(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, WebElement element, String value){
       element.clear();
       element.sendKeys(value);
    }

    public String getElementText(WebDriver driver, WebElement element){
        return element.getText();
    }

    public boolean isElementDisplayed(WebDriver driver, WebElement element){
        return element.isDisplayed();
    }

    public void waitForElementVisible(WebDriver driver, WebElement element){
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllElementsVisible(WebDriver driver, List<WebElement> elements){
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element){
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private Alert alert;
    private Select select;
    private Actions action;
    private int timeout = 30;
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
}
