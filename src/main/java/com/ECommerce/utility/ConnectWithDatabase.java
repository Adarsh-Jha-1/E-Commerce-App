package com.ECommerce.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectWithDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/e-commerce";
    private static final String USER = "root";
    private static final String PASSWORD = "@mysql2024";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            handleException("MySQL JDBC Driver not found. Make sure it is added to your classpath.", e);
        } catch (SQLException e) {
            handleException("Failed to connect to the database.", e);
        }
        return null;
    }

    private static void handleException(String message, Exception e) {
        e.printStackTrace();
        System.err.println(message);
    }
}
