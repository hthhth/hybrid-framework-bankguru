package com.bankguru.login;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_Register_Login_Base_Page_1 {
    WebDriver driver;
//    String projectLocation = System.getProperty("user.dir");
    BasePage basePage;
    String username, password;
    String loginPageURL;

    @BeforeClass
    public void initBrowser(){
        System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/V4/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        basePage = new BasePage();
    }

    @Test
    public void Login_01_Register_To_System(){
        loginPageURL = basePage.getPageURL(driver);
        basePage.clickToElement(driver, "//a[text()='here']");
        basePage.sendKeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
        basePage.clickToElement(driver, "//input[@name='btnLogin']");
        username = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
        password = basePage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");

    }
    @Test
    public void Login_02_Login_To_System(){
        basePage.openPageURL(driver, loginPageURL);
        basePage.sendKeyToElement(driver, "//input[@name='uid']", username);
        basePage.sendKeyToElement(driver, "//input[@name='password']", password);
        basePage.clickToElement(driver, "//input[@name='btnLogin']");

        Assert.assertEquals(basePage.getElementText(driver, "//marquee[@class='heading3']"),
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
