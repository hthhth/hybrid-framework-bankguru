package com.liveguru.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_04_Register_Login_Multiple_Browser {
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
        driver.get("http://live.demoguru99.com/index.php");
    }

    @Test
    public void Login_01_Empty_Email_And_Password(){

        homePage = new HomePageObject(driver);

        homePage.clickToMyAccountFooterLink();

        loginPage = new LoginPageObject(driver);
        loginPage.loginToSystem("", "");

        Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
        Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

    }

    @Test
    public void Login_02_Invalid_Email(){
        loginPage.refreshCurrentPage(driver);

        loginPage.loginToSystem("123@456.789", "123456");

        Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Password less than 6 chars")
    public void Login_03_Invalid_Password(){
        loginPage.refreshCurrentPage(driver);

        loginPage.loginToSystem("test@gmail.com", "123");

        Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test(description = "Email not exist in system")
    public void Login_04_Incorrect_Email(){
        loginPage.refreshCurrentPage(driver);

        loginPage.loginToSystem(getRandomEmail(), "123456");

        Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
    }

    @Test
    public void Login_05_Incorrect_Password(){
        loginPage.refreshCurrentPage(driver);

        loginPage.loginToSystem("a@gmail.com", "111111");

        Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
    }

    @Test
    public void Login_06_Valid_Email_And_Password(){
        loginPage.refreshCurrentPage(driver);

        loginPage.loginToSystem("a@gmail.com", "123456");

        myDashboardPage = new MyDashboardPageObject(driver);
        Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
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
    MyDashboardPageObject myDashboardPage;
}
