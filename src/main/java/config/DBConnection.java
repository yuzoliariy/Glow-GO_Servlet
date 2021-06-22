package config;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;

    public static synchronized Connection getConnection()
            throws SQLException {

        if (conn == null) {
            conn = initConnection();
        }
        return conn;
    }

    private static Connection initConnection()
            throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/makeupdb?serverTimezone=UTC",
                "root",
                "root");
    }
}
