package com.saucelab.sort;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pabeObjects.saucelab.InventoryPageObject;
import pabeObjects.saucelab.LoginPageObject;
import pabeObjects.saucelab.PageGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level_18_Sort extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    InventoryPageObject inventoryPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUsernameTextbox("standard_user");
        loginPage.enterToPasswordTextbox("secret_sauce");
        inventoryPage = loginPage.clickToLoginButton();
    }

//    @Test
    public void Sort_01_Name() {
        inventoryPage.selectItemInSortDropdown("Name (A to Z)");
        inventoryPage.sleepInSeconds(3);
        verifyTrue(inventoryPage.isProductNameSortAscending());

        inventoryPage.selectItemInSortDropdown("Name (Z to A)");
        inventoryPage.sleepInSeconds(3);
        verifyTrue(inventoryPage.isProductNameSortDescending());
    }

//    @Test
    public void Sort_02_Price(){
        inventoryPage.selectItemInSortDropdown("Price (low to high)");
        inventoryPage.sleepInSeconds(3);
        verifyTrue(inventoryPage.isProductPriceSortAscending());

        inventoryPage.selectItemInSortDropdown("Price (high to low)");
        inventoryPage.sleepInSeconds(3);
        verifyTrue(inventoryPage.isProductPriceSortDescending());

    }

    @Test
    public void Sort_03_Name_SortAscVerifyDes() {
        inventoryPage.selectItemInSortDropdown("Name (A to Z)");
        inventoryPage.sleepInSeconds(3);
        verifyTrue(inventoryPage.isProductNameSortDescending());
    }



    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser '" + browserName + "'");
    }

}
