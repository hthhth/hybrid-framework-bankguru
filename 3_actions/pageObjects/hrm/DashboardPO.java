package pageObjects.hrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import utilities.SQLServerJTDSConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DashboardPO extends BasePage {
    WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public int getEmployeeListNumberUI() {
        return 18;
    }

    public int getEmployeeListNumberInDB() throws SQLException {
        ArrayList<String> employeeList = new ArrayList<String>();
        String sql = "SELECT * from [automationfc].[dbo].[EMPLOYEE]";
        Connection conn = null;
        try {
            conn = SQLServerJTDSConnection.getSQLServerConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                employeeList.add(resultSet.getString("EMP_ID"));
                System.out.println(resultSet.getString("First_Name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return employeeList.size();
    }
}
