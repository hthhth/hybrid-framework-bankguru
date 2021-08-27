package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;

import java.lang.reflect.Method;
import java.util.Random;

public class Level_13_Register_Login_Log_ExtentReport_V2 extends BaseTest {
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
    public void User_01_Register_To_System(Method method){
//        ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
//        ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Verify Home Page is displayed");
//        homePage = PageGeneratorManager.getHomePage(driver);
//        verifyTrue(homePage.isHomePageSliderDisplayed());
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 02: Click to Register link");
//        registerPage = homePage.clickToRegiterLink();
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 03: Click to Male radio button");
//        registerPage.clickToGenderMaleRadioButton();
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 04: Enter to Firstname textbox");
//        registerPage.enterToFirstNameTextbox("John");
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 05: Enter to Lastname textbox");
//        registerPage.enterToLastNameTextbox("Terry");
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 06: Enter to Email textbox with value " + emailAddress);
//        registerPage.enterToEmailTextbox(emailAddress);
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 07: Enter to Password textbox with value " + password);
//        registerPage.enterToPasswordTextbox(password);
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 08: Enter to Confirm Password textbox with value " + password);
//        registerPage.enterToConfirmPasswordTextbox(password);
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 09: Click to Register button");
//        registerPage.clickToRegisterButton();
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 10: Verify success message displayed");
//        verifyTrue(registerPage.isSuccessMessageDisplayed());
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 11: Click to Logout  link");
//        homePage = registerPage.clickToLogoutLink();
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 12: Verify Home Page displayed");
//        verifyTrue(homePage.isHomePageSliderDisplayed());
//        ExtentTestManager.endTest();
    }

    @Test
    public void User_02_Login_To_System(Method method){
//        E ExtentTestManager.startTest(method.getName(), "User_02_Login_To_System");
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 01: Click to Login link");
//        loginPage = homePage.clickToLoginLink();
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 02: Enter to Email textbox with value " + emailAddress);
//        loginPage.enterToEmailTextbox(emailAddress);
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 03: Enter to Password textbox with value " + password);
//        loginPage.enterToPasswordTextbox(password);
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 04: Click to Login button");
//        homePage = loginPage.clickToLoginButton();
//
//        ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 05: Verify Home Page displayed");
//        verifyFalse(homePage.isHomePageSliderDisplayed());
//        xtentTestManager.endTest();
    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
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
