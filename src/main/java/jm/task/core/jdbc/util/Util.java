package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);
        config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        config.setProperty("hibernate.connection.url", url);
        config.setProperty("hibernate.connection.username", username);
        config.setProperty("hibernate.connection.password", password);
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.hbm2ddl.auto", "update");
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory;
    }
}
