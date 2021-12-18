package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getMySQLConnection() {
        String hostName = "localhost";
        String dbName = "automationfc";
        String userName = "root";
        String password = "abc123456";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
        Connection conn = null;
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        try {
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
