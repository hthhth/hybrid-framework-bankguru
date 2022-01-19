package com.nopcommerce.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.nopCommerce.*;

public class Level_10_Admin_Upload_File extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    ProductSearchPageObject productSearchPage;
    ProductDetailPageObject productDetailPage;
    String productAvatarImg = "ImageKM.jpg";
    String productAvatarAlt = "Avatar Alt";
    String productAvatarTitle = "Avatar Title";
    String productAvatarOrder = "1";
    String productName = "Adobe Photoshop CS4";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
//        driver = getBrowserDriverLocal(browserName, appURL);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToEmailTextbox("admin@yourstore.com");
        loginPage.enterToPasswordTextbox("admin");
        dashboardPage = loginPage.clickToLoginButton();

        dashboardPage.openSubMenuPageByName(driver, "Catalog", "Products");
        productSearchPage = PageGeneratorManager.getProductSearchPage(driver);

        productSearchPage.enterToProductNameTextBox(productName);
        productSearchPage.clickToSearchButton();
        productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);

    }

    @Test
    public void Admin_01_Upload_File(){
        productDetailPage.clickToExpandPanelByName("Pictures");

        productDetailPage.uploadMultipleFilesAtCardName(driver, "pictures", productAvatarImg);

        Assert.assertTrue(productDetailPage.isPicturedUploadedSuccessByFileName(""));

        productDetailPage.enterToAltTextbox(productAvatarAlt);
        productDetailPage.enterToTitleTextbox(productAvatarTitle);
        productDetailPage.clickToUpDownInDisplayOrderTextbox("Increase");

        productDetailPage.clickToAddProductPictureButton();

        Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName, productAvatarOrder, productAvatarAlt, productAvatarTitle));

        productSearchPage = productDetailPage.clickToSaveButton();

        Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));

        productSearchPage.enterToProductNameTextBox(productName);
        productSearchPage.clickToSearchButton();

        Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName, productName));

        productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
        productDetailPage.clickToExpandPanelByName("Pictures");
        productDetailPage.clickToDeleteButtonAtPictureName(productAvatarTitle); // Alert
        Assert.assertTrue(productDetailPage.isMessageDisplayedInEmptyTable(driver, "productpictures"));
        productSearchPage = productDetailPage.clickToSaveButton();

        productSearchPage.enterToProductNameTextBox(productName);
        productSearchPage.clickToSearchButton();

        Assert.assertTrue(productSearchPage.isPictureImageUpdated(productName, "default-image"));
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

}
