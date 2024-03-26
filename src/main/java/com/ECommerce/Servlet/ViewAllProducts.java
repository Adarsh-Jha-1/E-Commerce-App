package com.ECommerce.Servlet;

import java.io.IOException;
import java.util.List;

import com.ECommerce.DAO.ProductDAO;
import com.ECommerce.entity.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewProduct")
public class ViewAllProducts extends HttpServlet {
    
    private ProductDAO productDAO;

    public ViewAllProducts() {
        super();
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productDAO.fetchAllProduct();
        req.setAttribute("ProductList", productList);
        RequestDispatcher rd = req.getRequestDispatcher("/allProducts.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
