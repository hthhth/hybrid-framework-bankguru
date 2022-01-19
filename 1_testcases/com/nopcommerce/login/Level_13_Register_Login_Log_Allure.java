package com.nopcommerce.login;

import commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;

import java.util.Random;

@Epic("Web")
@Feature("User")
public class Level_13_Register_Login_Log_Allure extends BaseTest {
    WebDriver driver;
    String emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
//        driver = getBrowserDriverLocal(browserName, appURL);
        emailAddress = getRandomEmail();
        password = "123456";
    }

    @Story("Register")
    @Severity(SeverityLevel.NORMAL)
    @Description("Register to system and check register success")
    @Test
    public void User_01_Register_To_System(){

        log.info("User_01_Register2 - Step 01: Verify Home Page is displayed");
        homePage = PageGeneratorManager.getHomePage(driver);
        verifyTrue(homePage.isHomePageSliderDisplayed());

        log.info("User_01_Register - Step 02: Click to Register link");
        registerPage = homePage.clickToRegiterLink();

        log.info("User_01_Register - Step 03: Click to Male radio button");
        registerPage.clickToGenderMaleRadioButton();

        log.info("User_01_Register - Step 04: Enter to Firstname textbox");
        registerPage.enterToFirstNameTextbox("John");

        log.info("User_01_Register - Step 05: Enter to Lastname textbox");
        registerPage.enterToLastNameTextbox("Terry");

        log.info("User_01_Register - Step 06: Enter to Email textbox with value " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_01_Register - Step 07: Enter to Password textbox with value " + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("User_01_Register - Step 09: Click to Register button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - Step 10: Verify success message displayed");
        verifyTrue(registerPage.isSuccessMessageDisplayed());

        log.info("User_01_Register - Step 11: Click to Logout  link");
        homePage = registerPage.clickToLogoutLink();

        log.info("User_01_Register - Step 12: Verify Home Page displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }

    @Story("Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login to system and check login success")
    @Test
    public void User_02_Login_To_System(){
        log.info("User_02_Login - Step 01: Click to Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("User_02_Login - Step 02: Enter to Email textbox with value " + emailAddress);
        loginPage.enterToEmailTextbox(emailAddress);

        log.info("User_02_Login - Step 03: Enter to Password textbox with value " + password);
        loginPage.enterToPasswordTextbox(password);

        log.info("User_02_Login - Step 04: Click to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("User_02_Login - Step 05: Verify Home Page displayed");
        verifyFalse(homePage.isHomePageSliderDisplayed());
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
