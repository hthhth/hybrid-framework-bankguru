package com.bankguru.payment;

import commons.BaseTest;
import environmentConfig.Environment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Level_21_Multiple_Environment extends BaseTest {
    WebDriver driver;
    Environment environment;

    @Parameters({"envName", "serverName", "browser", "ipAddress", "port", "os", "os_version"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome")  String browser, @Optional("localhost")  String ipAddress,
                            @Optional("4444")  String port, @Optional("Windows")  String osName, @Optional("10")  String osVersion) {
        environment = ConfigFactory.create(Environment.class);
        driver = getBrowserDriver(envName, environment.appUrl(), browser, ipAddress, port, osName, osVersion);

//    @Parameters({"browser", "url"})
//    @BeforeClass
//    public void beforeClass(String browserName, String appUrl) {
//        ConfigFactory.setProperty("env", appUrl);

//        environment = ConfigFactory.create(Environment.class);

//        driver = getBrowserDriverLocal(browserName, environment.appUrl());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void Employee_01_Add_New_Employee() {

    }

//    @Test
    public void Employee_02_Upload_Avatar() throws InterruptedException {
    }
//    @Test
    public void Employee_03_Personal_Details() {
    }
//    @Test
    public void Employee_04_Contact_Details() {
    }
//    @Test
    public void Employee_05_Emergency_Details() {

    }
//    @Test
    public void Employee_06_Assigned_Dependents() {

    }
//    @Test
    public void Employee_07_Edit_View_Job() {

    }
//    @Test
    public void Employee_08_Edit_View_Salary() {

    }
//    @Test
    public void Employee_09_Edit_View_Tax() {

    }
//    @Test
    public void Employee_10_Qualifications() {

    }
//    @Test
    public void Employee_11_Search_Employee() {

    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser '" + browserName + "'");
    }


}

