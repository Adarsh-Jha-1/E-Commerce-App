package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.ECommerce.DAO.MerchantDAO;
import com.ECommerce.entity.Merchant;
import com.ECommerce.utility.ConnectWithDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginMerchant")
public class LoginMerchant extends HttpServlet {
	
	 private static final Logger LOGGER = Logger.getLogger(LoginMerchant.class.getName());

	Connection con;
	private MerchantDAO merchantDAO;

	public LoginMerchant() {
		super();
		this.con = ConnectWithDatabase.getConnection();
		merchantDAO = new MerchantDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			Merchant merchant = merchantDAO.login(email, password);

			if (merchant != null) {
				HttpSession session = req.getSession();
				session.setAttribute("MerchantId", merchant.getId());
				LOGGER.info("Merchant logged in successfully: " + merchant.getId());
				RequestDispatcher rd = req.getRequestDispatcher("/MerchantOptions.jsp");
				rd.forward(req, res);
			} else {
				req.setAttribute("errorMessage", "Invalid credentials");
				LOGGER.warning("Login failed for email: " + email);
				RequestDispatcher rd = req.getRequestDispatcher("/MerchantLogin.jsp");
				rd.forward(req, res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
