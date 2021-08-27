package com.facebook.register;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Register_Login_Assert_Verify extends BaseTest {
    WebDriver driver;
    RegisterPageObject registerPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);

        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void Register_01_Verify(){
        // Fail 1
        verifyFalse(registerPage.isEmailTextboxDisplayed());

        registerPage.enterToEmailTextbox("testauto@gmail.com");
        registerPage.sleepInSeconds(3);

        // Fail 2
        verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
        registerPage.enterToEmailTextbox("");
        registerPage.sleepInSeconds(3);

        verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());

        verifyTrue(registerPage.isConfirmEmailTextboxUndisplayed());

        // Fail 3
        verifyFalse(registerPage.isLoginButtonUndisplayed());
    }

    @Test
    public void Register_02_Verify(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
