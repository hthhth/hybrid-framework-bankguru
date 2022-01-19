package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

import java.util.Random;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {
    WebDriver driver;
    String emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
//        driver = getBrowserDriverLocal(browserName, appURL);
        emailAddress = getRandomEmail();
        password = "123456";
    }

    @Test
    public void Login_01_Register_To_System(){
        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        homePage.clickToRegiterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.clickToGenderMaleRadioButton();
        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Terry");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
        registerPage.clickToLogoutLink();

        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void Login_02_Login_To_System(){
        homePage.clickToLoginLink();

        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);
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
