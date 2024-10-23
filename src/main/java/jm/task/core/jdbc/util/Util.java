package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Condition;

public class Util {
    private static String  url = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL database");
        } catch (SQLException e) {
            System.out.println("Not connected to PostgreSQL database");
        }
        return connection;
    }
}
