package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Register_Login_Page_Object{
    WebDriver driver;
//    String projectLocation = System.getProperty("user.dir");
    String emailAddress, password;

    @BeforeClass
    public void initBrowser(){
        System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        emailAddress = getRandomEmail();
        password = "123456";
    }

    @Test
    public void Login_01_Register_To_System(){
        driver.get("https://demo.nopcommerce.com/");
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
