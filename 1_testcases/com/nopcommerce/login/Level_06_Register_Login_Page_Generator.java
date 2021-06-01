package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

import java.util.Random;

public class Level_06_Register_Login_Page_Generator extends BaseTest {
    WebDriver driver;
    String emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);
        emailAddress = getRandomEmail();
        password = "123456";
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Login_01_Register_To_System(){

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
}
