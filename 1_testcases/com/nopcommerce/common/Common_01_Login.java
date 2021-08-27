package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pageObjects.user.nopCommerce.*;

import java.util.Set;

public class Common_01_Login extends BaseTest {
    WebDriver driver;
    String emailAddress, password;
    public static Set<Cookie> loginPageCookie;

//    @Parameters({"browser", "url"})
//    @BeforeTest
//    public void beforeTest(String browserName, String appURL){
//        log.info("Pre-Condition101112: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
//        driver = getBrowserDriver(browserName, appURL);
//        emailAddress = getRandomEmail();
//        password = "123456";
//
//        log.info("Common_01 - Step 01: Verify Home Page is displayed");
//        homePage = PageGeneratorManager.getHomePage(driver);             //1
//        verifyTrue(homePage.isHomePageSliderDisplayed());
//
//        log.info("Common_01 - Step 02: Click to Register link");
//        registerPage = homePage.clickToRegiterLink();
//
//        log.info("Common_01 - Step 03: Click to Male radio button");
//        registerPage.clickToGenderMaleRadioButton();
//
//        log.info("Common_01 - Step 04: Enter to Firstname textbox");
//        registerPage.enterToFirstNameTextbox("John");
//
//        log.info("Common_01 - Step 05: Enter to Lastname textbox");
//        registerPage.enterToLastNameTextbox("Terry");
//
//        log.info("Common_01 - Step 06: Enter to Email textbox with value " + emailAddress);
//        registerPage.enterToEmailTextbox(emailAddress);
//
//        log.info("Common_01 - Step 07: Enter to Password textbox with value " + password);
//        registerPage.enterToPasswordTextbox(password);
//
//        log.info("Common_01 - Step 08: Enter to Confirm Password textbox with value " + password);
//        registerPage.enterToConfirmPasswordTextbox(password);
//
//        log.info("Common_01 - Step 09: Click to Register button");
//        registerPage.clickToRegisterButton();
//
//        log.info("Common_01 - Step 10: Verify success message displayed");
//        verifyTrue(registerPage.isSuccessMessageDisplayed());
//
//        log.info("Common_01 - Step 11: Click to Logout  link");
//        homePage = registerPage.clickToLogoutLink();
//
//        log.info("Common_01 - Step 12: Verify Home Page displayed");
//        verifyTrue(homePage.isHomePageSliderDisplayed());
//
//        log.info("Common_01 - Step 13: Click to Login link");
//        loginPage = homePage.clickToLoginLink();                        //2
//
//        log.info("Common_01 - Step 14: Enter to Email textbox with value " + emailAddress);
//        loginPage.enterToEmailTextbox(emailAddress);
//
//        log.info("Common_01 - Step 15: Enter to Password textbox with value " + password);
//        loginPage.enterToPasswordTextbox(password);
//
//        log.info("Common_01 - Step 16: Click to Login button");
//        homePage = loginPage.clickToLoginButton();
//
//        log.info("Common_01 - Step 17: Verify Home Page displayed");
//        verifyTrue(homePage.isHomePageSliderDisplayed());
//
//        log.info("Common_01 - Step 18: Get all login page cookies");
//        loginPageCookie = homePage.getAllCookies(driver);
//
//        log.info("Post-Condition: Close browser '" + browserName + "'");
//        cleanBrowserAndDriver();                                            //3
//    }

    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    SearchPageObject searchPage;
    MyAccountPageObject myAccountPage;
    OrderPageObject orderPage;
}
