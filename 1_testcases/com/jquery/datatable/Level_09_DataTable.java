package com.jquery.datatable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;


public class Level_09_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
//        driver = getBrowserDriverLocal(browserName, appURL);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

//    @Test
    public void Table_01_Paging(){

        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageActiveByNumber("15"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageActiveByNumber("5"));

        homePage.openPageByNumber("20");
        Assert.assertTrue(homePage.isPageActiveByNumber("20"));

    }

//    @Test
    public void Table_02_Input_Header_Textbox(){
        homePage.inputToHeaderTextboxByName("Females", "777");
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        homePage.inputToHeaderTextboxByName("Country", "Islamic Republic of Iran");
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        homePage.inputToHeaderTextboxByName("Males", "29300");
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);
    }

//    @Test
    public void Table_03_Click_Icon(){
        homePage.clickToIconByCountryName("Argentina", "remove");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByCountryName("Algeria", "remove");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByCountryName("Arab Rep of Egypt", "edit");
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        homePage.clickToIconByCountryName("Aruba", "edit");
        homePage.sleepInSeconds(3);
    }
//    @Test
    public void Table_04_Verify_Row_Values(){
        homePage.inputToHeaderTextboxByName("Country", "Afghanistan");
        Assert.assertTrue(homePage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        homePage.inputToHeaderTextboxByName("Country", "Arab Rep of Egypt");
        Assert.assertTrue(homePage.isRowValueDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

    }

//    @Test
    public void Table_05_Input_To_Row_Textbox(){
        homePage.inputToTextboxByRowNumber("Contact Person", "3", "John Kenedy");
        homePage.sleepInSeconds(3);

        homePage.inputToTextboxByRowNumber("Order Placed", "1", "5");
        homePage.sleepInSeconds(3);

        homePage.inputToTextboxByRowNumber("Company", "2", "Apple");
        homePage.sleepInSeconds(3);

        homePage.inputToTextboxByRowNumber("Member Since", "3", "1950");
        homePage.sleepInSeconds(3);

    }

    @Test
    public void Table_06_Click_Icon_At_Row() {
        homePage.clickToIconByRowNumber("2", "Move Up");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByRowNumber("3", "Remove Current Row");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByRowNumber("2", "Remove Current Row");
        homePage.sleepInSeconds(3);

        homePage.clickToIconByRowNumber("1", "Remove Current Row");
        homePage.sleepInSeconds(3);
    }

        @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
