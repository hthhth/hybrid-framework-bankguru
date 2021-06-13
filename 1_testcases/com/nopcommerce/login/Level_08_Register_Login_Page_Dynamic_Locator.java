package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;

import java.util.Random;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {
    WebDriver driver;
    String emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);
        emailAddress = getRandomEmail();
        password = "123456";
    }

    @Test
    public void Login_01_Register_To_System(){
        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        registerPage = homePage.clickToRegiterLink();
        registerPage.clickToGenderMaleRadioButton();
        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Terry");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

        homePage = registerPage.clickToLogoutLink();
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void Login_02_Login_To_System(){
        loginPage = homePage.clickToLoginLink();
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);

        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());
    }
    @Test
    public void Login_03_Open_Page_At_Footer(){
        searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");

        myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver, "My account");

        orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver, "Orders");

        myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver, "My account");

        searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver, "Search");
        orderPage = (OrderPageObject) searchPage.getFooterPageByName(driver, "Orders");

    }
    @Test
    public void Login_04_Open_Page_At_Footer(){
        orderPage.openFooterPageByName(driver, "My account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

        myAccountPage.openFooterPageByName(driver, "Search");
        searchPage = PageGeneratorManager.getSearchPage(driver);

        searchPage.openFooterPageByName(driver, "Orders");
        orderPage = PageGeneratorManager.getOrderPage(driver);
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    public String getRandomEmail(){
        Random rand = new Random();
        return "testing" + rand.nextInt(99999) + "@live.com";
    }

    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    SearchPageObject searchPage;
    MyAccountPageObject myAccountPage;
    OrderPageObject orderPage;
}
