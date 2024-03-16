package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ECommerce.utility.ConnectWithDatabase;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/CheckValidMerchant")
public class CheckMerchant extends GenericServlet {

	ConnectWithDatabase con;

	public CheckMerchant() {
		super();
		con = new ConnectWithDatabase();

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String insertQuery = "Select * from Merchant where email=? and password=?";
		PreparedStatement statement;
		try {
			statement = con.getConnection().prepareStatement(insertQuery);
			statement.setString(1, email);
			statement.setString(2, password);

			if (statement.execute()) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
