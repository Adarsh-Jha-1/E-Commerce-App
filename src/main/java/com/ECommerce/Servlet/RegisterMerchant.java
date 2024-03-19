package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.ECommerce.DAO.MerchantDAO;
import com.ECommerce.entity.Merchant;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/registerMerchant")
public class RegisterMerchant extends GenericServlet {
    private MerchantDAO merchantDAO;

    public RegisterMerchant() {
        super();
        merchantDAO = new MerchantDAO();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Long mobileNumber = Long.parseLong(req.getParameter("mobileNumber"));
        String password = req.getParameter("password");

        Merchant merchant = new Merchant(name, email, mobileNumber, password);
        try {
            merchantDAO.saveMerchant(merchant);
            RequestDispatcher rd = req.getRequestDispatcher("/MerchantLogin.jsp");
            rd.forward(req, res);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
