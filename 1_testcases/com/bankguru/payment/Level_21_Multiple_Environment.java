package com.bankguru.payment;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_21_Multiple_Environment extends BaseTest {
    WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
        driver = getBrowserDriver(browserName, appURL);
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

