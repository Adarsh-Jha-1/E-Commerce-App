package com.ECommerce.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ECommerce.DAO.MerchantDAO;
import com.ECommerce.DAO.MerchantProductDAO;
import com.ECommerce.DAO.ProductDAO;
import com.ECommerce.entity.Merchant;
import com.ECommerce.entity.MerchantProduct;
import com.ECommerce.entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addProduct")
public class RegisterProduct extends HttpServlet {

	private MerchantDAO merchantDAO;
	private ProductDAO productDao;
	RequestDispatcher rd;

	public RegisterProduct() {
		this.merchantDAO = new MerchantDAO();
		this.productDao = new ProductDAO();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String brand = req.getParameter("brand");
	    String category = req.getParameter("category");
	    String model = req.getParameter("model");
	    Double price = Double.parseDouble(req.getParameter("price"));
	    Integer stock = Integer.parseInt(req.getParameter("stock"));
	    Product product = new Product(brand, category, model, price, stock);

	    try {
	        int productId =  productDao.saveProduct(product);
	        HttpSession session = req.getSession(false);
	        if (session != null && session.getAttribute("MerchantId") != null) {
	            int merchantId = (int) session.getAttribute("MerchantId");
	            Merchant merchant = merchantDAO.findMerchantById(merchantId);
	            if (merchant != null) {
	                List<Product> productsList = merchant.getProducts();
	                if (productsList != null) {
	                    productsList.add(product);
	                } else {
	                    productsList = new ArrayList<>();
	                    productsList.add(product);
	                }
	                merchant.setProducts(productsList);
	                MerchantProduct merchantProduct = new MerchantProduct(merchantId, productId);
	                MerchantProductDAO merchantProductDAO = new MerchantProductDAO();
	                merchantProductDAO.addMerchantProduct(merchantProduct);
	                rd = req.getRequestDispatcher("addproduct.jsp");
	                rd.forward(req, resp);
	            } else {
	                String errorMessage = "Merchant not found";
	                req.setAttribute("errorMessage", errorMessage);
	                rd = req.getRequestDispatcher("error.jsp");
	                rd.forward(req, resp);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
