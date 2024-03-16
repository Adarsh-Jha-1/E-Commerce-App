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


@WebServlet("/SaveMerchant")
public class SaveMerchant extends GenericServlet{
	ConnectWithDatabase con;

	public SaveMerchant() {
		super();
		con = new ConnectWithDatabase();

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String Name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobileNumber = req.getParameter("mobileNumber");
		String password = req.getParameter("password");
		

		String insertQuery = "Insert into Merchant (name,email,mobileNumber,password)Values(?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.getConnection().prepareStatement(insertQuery);
			statement.setString(1, Name);
			statement.setString(2, email);
			statement.setString(3, mobileNumber);
			statement.setString(4, password);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
