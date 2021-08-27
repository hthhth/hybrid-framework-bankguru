package com.nopcommerce.login;

import com.nopcommerce.common.Common_01_Login;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.nopCommerce.*;

public class Level_14_Register_Login_Share_State extends BaseTest {
    WebDriver driver;
    String emailAddress, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) throws InterruptedException {
        log.info("Pre-Condition789: Open browser '" + browserName + "' and navigate to '" + appURL + "'");  //4
        driver = getBrowserDriver(browserName, appURL);
        homePage = PageGeneratorManager.getHomePage(driver);

        log.info("Pre-Condition - Step 01: Click to Login link");  //7
        loginPage = homePage.clickToLoginLink();  // 2                //8

        log.info("Pre-Condition - Step 02: Set login page cookie");
        loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
        loginPage.sleepInSeconds(3);
        loginPage.refreshCurrentPage(driver);

        log.info("Pre-Condition - Step 03: Click to HomePage image");
        homePage = loginPage.openHomePage(driver);

        log.info("Pre-Condition - Step 04: Verify Home Page displayed");
        verifyTrue(homePage.isHomePageSliderDisplayed());
    }

    @Test
    public void User_01_Create_New_Account(){

    }

    @Test
    public void User_02_Move_Account(){

    }

    @Test
    public void User_03_Delete_Account(){

    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser '" + browserName + "'");
        cleanExecutableDriver();  // 3
    }

    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    SearchPageObject searchPage;
    MyAccountPageObject myAccountPage;
    OrderPageObject orderPage;
}
