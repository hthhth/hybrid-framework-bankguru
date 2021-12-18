package com.hrm.employee;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.hrm.*;

import java.sql.SQLException;

public class Level_22_Database_UI extends BaseTest {
    WebDriver driver;

    String adminUserName, adminPassword;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
        driver = getBrowserDriver(browserName, appURL);
        loginPage = PageGenerator.getLoginPage(driver);

        adminUserName = "Admin";
        adminPassword = "admin123";

        log.info("Pre-Condition - Step 02: Login with Admin role");
        dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
        showBrowserConsoleLogs(driver);
    }

    @Test
    public void Employee_Search() throws SQLException {
        log.info("Employee_Search_01 - Step 01: Get employee size on UI");
        int employeeListNumberUI = dashboardPage.getEmployeeListNumberUI();
        log.info("Employee_Search_01 - Step 02: Get employee size in DB");
        int employeeListNumberDB = dashboardPage.getEmployeeListNumberInDB();
        log.info("Employee_Search_01 - Step 03: Verify employee size in UI and DB");
        verifyEquals(employeeListNumberUI, employeeListNumberDB);
    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser '" + browserName + "'");
    }

    LoginPO loginPage;
    DashboardPO dashboardPage;

}

