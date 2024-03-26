package com.ECommerce.Servlet;

import com.ECommerce.DAO.ProductDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteProducts")
public class DeleteProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.parseInt(request.getParameter("id"));

        boolean deleted = deleteProduct(productId);

        if (deleted) {
            response.sendRedirect("viewProduct");
        } else {
            response.getWriter().println("Failed to delete product with ID: " + productId);
        }
    }

    

    private boolean deleteProduct(int productId) {
        ProductDAO productDAO = new ProductDAO();
        try {
            boolean deleted = productDAO.deleteProductByID(productId);
            return deleted;
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }

}
