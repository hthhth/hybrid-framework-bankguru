package com.bankguru.login;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_Register_Login_Base_Page_3 extends BasePage{
    WebDriver driver;
//    String projectLocation = System.getProperty("user.dir");
    String username, password;
    String loginPageURL;

    @BeforeClass
    public void initBrowser(){
        System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/V4/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void Login_01_Register_To_System(){
        loginPageURL = getPageURL(driver);
        clickToElement(driver, "//a[text()='here']");
        sendKeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
        clickToElement(driver, "//input[@name='btnLogin']");
        username = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
        password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");

    }
    @Test
    public void Login_02_Login_To_System(){
        openPageURL(driver, loginPageURL);
        sendKeyToElement(driver, "//input[@name='uid']", username);
        sendKeyToElement(driver, "//input[@name='password']", password);
        clickToElement(driver, "//input[@name='btnLogin']");

        Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"),
                "Welcome To Manager's Page of Guru99 Bank");
    }
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    public String getRandomEmail(){
        Random rand = new Random();
        return "testing" + rand.nextInt(99999) + "@live.com";
    }
}
