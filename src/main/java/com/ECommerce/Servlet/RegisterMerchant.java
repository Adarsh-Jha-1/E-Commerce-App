package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.ECommerce.DAO.MerchantDAO;
import com.ECommerce.entity.Merchant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerMerchant")
public class RegisterMerchant extends HttpServlet {
    private MerchantDAO merchantDAO;

    public RegisterMerchant() {
        super();
        merchantDAO = new MerchantDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Long mobileNumber = Long.parseLong(req.getParameter("mobileNumber"));
        String password = req.getParameter("password");

        Merchant merchant = new Merchant(name, email, mobileNumber, password);
        try {
            merchantDAO.saveMerchant(merchant);
            res.sendRedirect(req.getContextPath() + "/MerchantLogin.jsp");
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            // Forward to an error page or display an error message
            req.setAttribute("errorMessage", "Error registering merchant. Please try again.");
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
