package com.ECommerce.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectWithDatabase {

	public  Connection getConnection() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/{Enter your Database name}", "root", "root");
		return con;
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;

	}
}
