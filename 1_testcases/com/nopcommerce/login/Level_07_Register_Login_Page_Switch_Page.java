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

public class Level_07_Register_Login_Page_Switch_Page extends BaseTest {
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
    public void Login_03_Switch_Page_At_Footer(){
        searchPage = homePage.openSearchPage(driver);

        myAccountPage = searchPage.openMyAccountPage(driver);

        orderPage = myAccountPage.openOrderPage(driver);

        myAccountPage = orderPage.openMyAccountPage(driver);

        searchPage = myAccountPage.openSearchPage(driver);
        orderPage = searchPage.openOrderPage(driver);

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
