package com.hrm.employee;

import com.hrm.data.Employee;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.hrm.*;

public class Level_20_Data_Test_III_Out_Class extends BaseTest {
    WebDriver driver;
    String employeeID;
    String statusValue;
    String avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "Star.jpg";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appURL + "'");
//        driver = getBrowserDriverLocal(browserName, appURL);
        loginPage = PageGenerator.getLoginPage(driver);

        statusValue = "Enabled";

        log.info("Pre-Condition - Step 02: Login with Admin role");
        dashboardPage = loginPage.loginToSystem(driver, Employee.Role.ADMIN_USERNAME, Employee.Role.ADMIN_PASSWORD);
    }

    @Test
    public void Employee_01_Add_New_Employee() {
        log.info("Add_New_01 - Step 01: Open 'Employee List' page");
        dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
        employeeListPage = PageGenerator.getEmployeeListPage(driver);

        log.info("Add_New_01 - Step 02: Click to 'Add' button");
        employeeListPage.clickToButtonByID(driver, "btnAdd");
        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
        addEmployeePage.enterToTextboxByID_HRM(driver, "firstName", Employee.PersonalDetails.FIRSTNAME);

        log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
        addEmployeePage.enterToTextboxByID_HRM(driver, "lastName", Employee.PersonalDetails.LASTNAME);

        log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
        employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");

        log.info("Add_New_01 - Step 06: Click to 'Create Login Details' checkbox");
        addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");

        log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
        addEmployeePage.enterToTextboxByID_HRM(driver, "user_name", Employee.PersonalDetails.USERNAME);

        log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
        addEmployeePage.enterToTextboxByID_HRM(driver, "user_password", Employee.PersonalDetails.PASSWORD);

        log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
        addEmployeePage.enterToTextboxByID_HRM(driver, "re_password", Employee.PersonalDetails.PASSWORD);

        log.info("Add_New_01 - Step 10: Select '" + statusValue + "' value in 'Status' dropdown");
        addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);

        log.info("Add_New_01 - Step 11: Click to 'Save' button");
        addEmployeePage.clickToButtonByID(driver, "btnSave");
        myInfoPage = PageGenerator.getMyInfoPage(driver);

        log.info("Add_New_01 - Step 12: Open 'Employee List' page");
        myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
        employeeListPage = PageGenerator.getEmployeeListPage(driver);
//        employeeListPage.waitForElementInvisible(driver, EmployeeListPageUI.LOADING_ICON);
        verifyTrue(employeeListPage.isJQueryAJAXLoadedSuccess(driver));

        log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
        employeeListPage.enterToTextboxByID_HRM(driver, "empsearch_employee_name_empName", Employee.PersonalDetails.FULLNAME);

        log.info("Add_New_01 - Step 14: Click to 'Search' button");
        employeeListPage.clickToButtonByID(driver, "searchBtn");
//        employeeListPage.waitForElementInvisible(driver, EmployeeListPageUI.LOADING_ICON);
        verifyTrue(employeeListPage.isJQueryAJAXLoadedSuccess(driver));

        log.info("Add_New_01 - Step 15: Verify Employee Information displayed at 'Result Table'");
        verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
        verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), Employee.PersonalDetails.FIRSTNAME);
        verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), Employee.PersonalDetails.LASTNAME);

    }

    @Test
    public void Employee_02_Upload_Avatar() throws InterruptedException {
        log.info("Upload_Avatar_02 - Step 01: Login with Employee role");
        loginPage = employeeListPage.logoutSystem(driver);
        dashboardPage = loginPage.loginToSystem(driver, Employee.PersonalDetails.USERNAME, Employee.PersonalDetails.PASSWORD);

        log.info("Upload_Avatar_02 - Step 02: Open Personal Details page");
        dashboardPage.openMenuPage(driver, "My Info");
        myInfoPage = PageGenerator.getMyInfoPage(driver);

        log.info("Upload_Avatar_02 - Step 03: Click to Change Photo image");
        myInfoPage.clickToChangePhotoImage();

        log.info("Upload_Avatar_02 - Step 04: Upload new avatar image");
        myInfoPage.uploadImage(driver, avatarFilePath);

        log.info("Upload_Avatar_02 - Step 05: Click to Upload button");
        myInfoPage.clickToButtonByID(driver, "btnSave");

        log.info("Upload_Avatar_02 - Step 06: Verify success message displayed");
        verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver,"Successfully Uploaded"));

        log.info("Upload_Avatar_02 - Step 07: Verify new avatar image displayed");
        verifyTrue(myInfoPage.isNewAvatarImageDisplayed());
    }
    @Test
    public void Employee_03_Personal_Details() {
        log.info("Personal_Details_03 - Step 01: Open 'Personal Details' tab at sidebar'");
        myInfoPage.openTabAtSideBarByName("Personal Details");

        log.info("Personal_Details_03 - Step 02: Verify all fields at 'Personal Details' form are disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpFirstName"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpLastName"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_1"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_2"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbMarital"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbNation"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

        log.info("Personal_Details_03 - Step 03: Click to 'Edit' button at 'Personal Details' form");
        myInfoPage.clickToButtonByID(driver, "btnSave");

        log.info("Personal_Details_03 - Step 04: Verify 'Employee ID' textbox is disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));

        log.info("Personal_Details_03 - Step 05: Verify 'Driver's License Number' textbox is disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));

        log.info("Personal_Details_03 - Step 06: Verify 'SSN Number' textbox is disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));

        log.info("Personal_Details_03 - Step 07: Verify 'SIN Number' textbox is disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));

        log.info("Personal_Details_03 - Step 08: Verify 'Date of Birth' textbox is disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));

        log.info("Personal_Details_03 - Step 09: Enter new value to 'First Name' textbox");
        myInfoPage.enterToTextboxByID_HRM(driver, "personal_txtEmpFirstName", Employee.ContactDetails.FIRSTNAME);

        log.info("Personal_Details_03 - Step 10: Enter new value to 'Last Name' textbox");
        myInfoPage.enterToTextboxByID_HRM(driver, "personal_txtEmpLastName", Employee.ContactDetails.LASTNAME);

        log.info("Personal_Details_03 - Step 11: Select new value in 'Gender' radio button");
        myInfoPage.clickToRadioByLabel(driver, Employee.ContactDetails.GENDER);

        log.info("Personal_Details_03 - Step 12: Select new value in 'Marital Status' dropdown");
        myInfoPage.selectItemInDropdownByID(driver, "personal_cmbMarital", Employee.ContactDetails.MARITAL_STATUS);

        log.info("Personal_Details_03 - Step 13: Select new value in 'Nationality' dropdown");
        myInfoPage.selectItemInDropdownByID(driver, "personal_cmbNation", Employee.ContactDetails.NATIONALITY);

        log.info("Personal_Details_03 - Step 14: Click to 'Save' button at 'Personal Details' form");
        myInfoPage.clickToButtonByID(driver, "btnSave");

        log.info("Personal_Details_03 - Step 15: Verify success message displayed");
        verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver,"Successfully Saved"));

        log.info("Personal_Details_03 - Step 16: Verify 'First Name' textbox is updated successfully");
        verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), Employee.ContactDetails.FIRSTNAME);

        log.info("Personal_Details_03 - Step 17: Verify 'Last Name' textbox is updated successfully");
        verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), Employee.ContactDetails.LASTNAME);

        log.info("Personal_Details_03 - Step 18: Verify 'Gender' radio button is updated successfully");
        verifyTrue(myInfoPage.isRadioButtonSelectedByLabel(driver, Employee.ContactDetails.GENDER));

        log.info("Personal_Details_03 - Step 19: Verify 'Marital Status' dropdown is updated successfully");
        verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbMarital"), Employee.ContactDetails.MARITAL_STATUS);

        log.info("Personal_Details_03 - Step 20: Verify 'Nationality' dropdown is updated successfully");
        verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbNation"), Employee.ContactDetails.NATIONALITY);

        log.info("Personal_Details_03 - Step 21: Verify 'Employee Id' textbox value is correct");
        verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmployeeId"), employeeID);
    }
//    @Test
    public void Employee_04_Contact_Details() {
        log.info("Contact_Details_04 - Step 01: Open 'Contact Details' tab at sidebar'");
        myInfoPage.openTabAtSideBarByName("Contact Details");

        log.info("Contact_Details_04 - Step 02: Verify all fields at 'Contact Details' form are disabled");
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street1"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street2"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_city"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_province"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_zipcode"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_country"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_hm_telephone"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_mobile"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_telephone"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_work_email"));
        verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_oth_email"));

        log.info("Contact_Details_04 - Step 03: Click to 'Edit' button at 'Contact Details' form");
        myInfoPage.clickToButtonByID(driver, "btnSave");

        log.info("Contact_Details_04 - Step 04: Enter new value to 'Address Street 1' textbox");
    }
    @Test
    public void Employee_05_Emergency_Details() {

    }
    @Test
    public void Employee_06_Assigned_Dependents() {

    }
    @Test
    public void Employee_07_Edit_View_Job() {

    }
    @Test
    public void Employee_08_Edit_View_Salary() {

    }
    @Test
    public void Employee_09_Edit_View_Tax() {

    }
    @Test
    public void Employee_10_Qualifications() {

    }
    @Test
    public void Employee_11_Search_Employee() {

    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    public void cleanBrowser(String browserName) {
        log.info("Post-Condition: Close browser '" + browserName + "'");
    }

    LoginPO loginPage;
    AddEmployeePO addEmployeePage;
    DashboardPO dashboardPage;
    EmployeeListPO employeeListPage;
    MyInfoPO myInfoPage;
}

