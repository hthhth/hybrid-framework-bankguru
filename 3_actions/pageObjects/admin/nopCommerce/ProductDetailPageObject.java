package pageObjects.admin.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {
    WebDriver driver;

    public ProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToExpandPanelByName(String panelName) {
        waitForElementVisible(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
        // 1 - get tag i attribute
        String toggleIconStatus = getElementAttribute(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, "class", panelName);
        if (toggleIconStatus.contains("fa-plus")){
            waitForElementClickable(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
            clickToElement(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
        }
        //2 - if not contains (fa-plus)
        // 3 - if contains: click i
    }

    public boolean isPicturedUploadedSuccessByFileName(String fileName) {
        fileName = fileName.split("\\.")[0];
        waitForElementVisible(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILE_NAME, fileName);
    }

    public void enterToAltTextbox(String productImageAlt) {
        waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_NEW);
        sendKeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_NEW, productImageAlt);
    }

    public void enterToTitleTextbox(String productImageTitle) {
        waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW);
        sendKeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, productImageTitle);
    }

    public void clickToUpDownInDisplayOrderTextbox(String selectValue) {
        waitForElementClickable(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_UP_DOWN, selectValue);
        clickToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_UP_DOWN, selectValue);
    }

    public void clickToAddProductPictureButton() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
    }

    public boolean isPictureImageDisplayed(String imageName, String displayOrder, String imageAlt, String imageTitle) {
        imageName = imageName.replace(" ", "-").toLowerCase();
        waitForElementVisible(driver, ProductDetailPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, imageName, displayOrder, imageAlt, imageTitle);
        return isElementDisplayed(driver, ProductDetailPageUI.PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE, imageName, displayOrder, imageAlt, imageTitle);
    }

    public ProductSearchPageObject clickToSaveButton() {
        waitForElementClickable(driver, ProductDetailPageUI.SAVE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
        return PageGeneratorManager.getProductSearchPage(driver);
    }

    public void clickToDeleteButtonAtPictureName(String productTitle) {
        waitForElementClickable(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
        clickToElement(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
        sleepInSeconds(2);
        acceptAlert(driver);
    }

}
