package com.ECommerce.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectWithDatabase {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myhiber", "root", "root");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("MySQL JDBC Driver not found. Make sure it is added to your classpath.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to the database.");
        }
        return null;
    }
}