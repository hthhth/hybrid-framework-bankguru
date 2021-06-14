package com.facebook.register;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;
import pageUIs.facebook.RegisterPageUI;

import java.util.Random;

public class Level_11_Register_Login_Element_Undisplayed extends BaseTest {
    WebDriver driver;
    RegisterPageObject registerPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL){
        driver = getBrowserDriver(browserName, appURL);

        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void Register_01_Element_Displayed(){
        Assert.assertTrue(registerPage.isEmailTextboxDisplayed());

        registerPage.enterToEmailTextbox("testauto@gmail.com");
        registerPage.sleepInSeconds(3);
        Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
    }

    @Test
    public void Register_02_Element_Undisplayed_IN_DOM(){
        registerPage.enterToEmailTextbox("");
        registerPage.sleepInSeconds(3);
        Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());

        Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
    }

    @Test
    public void Register_03_Element_Undisplayed_NOT_IN_DOM(){
        Assert.assertFalse(registerPage.isLoginButtonDisplayed());
    }

    @Test
    public void Register_04_Element_Undisplayed_NOT_IN_DOM(){
        //findElements
        Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
