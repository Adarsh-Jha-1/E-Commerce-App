package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ECommerce.DAO.MerchantDAO;
import com.ECommerce.entity.Merchant;
import com.ECommerce.utility.ConnectWithDatabase;
import com.mysql.cj.Session;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;

@WebServlet("/loginMerchant")
public class LoginMerchant extends HttpServlet {

	ConnectWithDatabase con;
	private MerchantDAO merchantDAO;

	public LoginMerchant() {
		super();
		con = new ConnectWithDatabase();
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
				RequestDispatcher rd = req.getRequestDispatcher("/MerchantOptions.jsp");
				rd.forward(req, res);
			} else {
				req.setAttribute("errorMessage", "Invalid credentials");
				RequestDispatcher rd = req.getRequestDispatcher("/MerchantLogin.jsp");
				rd.forward(req, res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
