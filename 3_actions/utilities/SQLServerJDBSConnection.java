package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerJDBSConnection {
    public static Connection getSQLServerConnection() {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "automationfc";
        String userName = "sa";
        String password = "abc123456";
        return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
    }

    private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
        Connection conn = null;
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";databaseName=" + database + ";instance=" + sqlInstanceName;
        try {
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
