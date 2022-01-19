package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;

import java.util.Random;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
    WebDriver driver;
    String emailAddress, password;
    String date, month, year;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        log.info("Pre-Condition: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
//        driver = getBrowserDriverLocal(browserName, appURL);
        emailAddress = getRandomEmail();
        password = "123456";
        date = "8";
        month = "March";
        year = "2000";

    }

    @Test
    public void User_01_TheRegister_To_System(){
        log.info("User_01_Register2 - Step 01: Verify Home Page is displayed");
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isHomePageSliderDisplayed());

        log.info("User_01_Register - Step 02: Click to Register link");
        homePage.openHeaderPageByName(driver, "Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        log.info("User_01_Register - Step 03: Click to Male radio button");
        registerPage.clickToRadioButtonByText(driver, "Male");

        log.info("User_01_Register - Step 04: Enter to Firstname textbox");
        registerPage.enterToTextboxByID(driver, "FirstName", "John");

        log.info("User_01_Register - Step 05: Enter to Lastname textbox");
        registerPage.enterToTextboxByID(driver,"LastName", "Terry");

        log.info("User_01_Register - Step 06: Enter to Email textbox with value " + emailAddress);
        registerPage.enterToTextboxByID(driver,"Email", emailAddress);

        log.info("User_01_Register - Step 07: Enter to Password textbox with value " + password);
        registerPage.enterToTextboxByID(driver,"Password", password);

        log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value " + password);
        registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);

        log.info("User_01_Register - Step 09: Select item in Date dropdown");
        registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);

        log.info("User_01_Register - Step 10: Select item in Month dropdown");
        registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);

        log.info("User_01_Register - Step 11: Select item in Year dropdown");
        registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);

        log.info("User_01_Register - Step 12: Click to Register button");
        registerPage.clickToButtonByText(driver, "Register");

        log.info("User_01_Register - Step 13: Verify success message displayed");
        verifyTrue(registerPage.isSuccessMessageDisplayed());

        log.info("User_01_Register - Step 14: Click to Logout  link");
        registerPage.openHeaderPageByName(driver, "Log out");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("User_01_Register - Step 15: Verify Home Page displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void User_02_Login_To_System(){
        log.info("User_02_Login - Step 01: Click to Login link");
        homePage.openHeaderPageByName(driver, "Log in");
        loginPage = PageGeneratorManager.getLoginPage(driver);

        log.info("User_02_Login - Step 02: Enter to Email textbox with value " + emailAddress);
        loginPage.enterToTextboxByID(driver, "Email", emailAddress);

        log.info("User_02_Login - Step 03: Enter to Password textbox with value " + password);
        loginPage.enterToTextboxByID(driver, "Password", password);

        log.info("User_02_Login - Step 04: Click to Login button");
        loginPage.clickToButtonByText(driver, "Log in");
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("User_02_Login - Step 05: Verify Home Page displayed");
        verifyFalse(homePage.isHomePageSliderDisplayed());
    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser '" + browserName + "'");
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
