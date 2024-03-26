package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.ECommerce.DAO.ProductDAO;
import com.ECommerce.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editProduct")
public class EditMerchantProduct extends HttpServlet {
	ProductDAO productDao;
	
	public EditMerchantProduct(){
		this.productDao = new ProductDAO();
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int productId = Integer.parseInt(req.getParameter("id"));
    	Product product = productDao.findProductById(productId);
    	req.setAttribute("brand", product.getBrand());
    	req.setAttribute("category", product.getCategory());
    	req.setAttribute("model", product.getModel());
    	req.setAttribute("price", product.getPrice());
    	req.setAttribute("stock", product.getStock());
    	req.setAttribute("productId", product.getId());

        req.getRequestDispatcher("/editProductForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productBrand = req.getParameter("brand");
        String productCategory = req.getParameter("category");
        String productModel = req.getParameter("model");
        Double productPrice = Double.parseDouble(req.getParameter("price"));
        int productStock = Integer.parseInt(req.getParameter("stock"));
        
        Product product = new Product(productId, productBrand, productCategory, productModel, productPrice, productStock);
        
        try {
            productDao.updateProduct(product);
            
            req.setAttribute("updatedProduct", product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/productEdited.jsp").forward(req, resp);
    }
}
