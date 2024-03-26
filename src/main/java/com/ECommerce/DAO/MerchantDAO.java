package com.ECommerce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ECommerce.entity.Merchant;
import com.ECommerce.entity.Product;
import com.ECommerce.utility.ConnectWithDatabase;

public class MerchantDAO {

	Connection con;

	public MerchantDAO() {
		super();
		con = ConnectWithDatabase.getConnection();

	}

	public void saveMerchant(Merchant merchant) throws SQLException {
		PreparedStatement statement = con.prepareStatement(
				"INSERT INTO Merchant (name, email, mobileNumber, password)" + " VALUES (?, ?, ?, ?)");
		statement.setString(1, merchant.getName());
		statement.setString(2, merchant.getEmail());
		statement.setLong(3, merchant.getMobileNumber());
		statement.setString(4, merchant.getPassword());

		statement.executeUpdate();
	}

	public Merchant login(String email, String password) throws SQLException {
	    String selectQuery = "SELECT * FROM Merchant WHERE email=? AND password=?";
	    PreparedStatement statement = con.prepareStatement(selectQuery);
	    statement.setString(1, email);
	    statement.setString(2, password);
	    ResultSet rs = statement.executeQuery();
	    
	    if (rs.next()) {
	        int id = rs.getInt("id");
	        String name = rs.getString("name");
	        Long mobileNumber = rs.getLong("mobileNumber");
	        Merchant merchant = new Merchant(id, name, email, mobileNumber, password);
	        return merchant;
	    } else {
	        return null;
	    }
	}


	public void updateMerchantInfo(Merchant m) throws SQLException {
		PreparedStatement statement = null;
		try {
	        String query = "UPDATE Merchant SET name=?, email=?, mobile_number=?, password=? WHERE id=?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, m.getName());
	        statement.setString(2, m.getEmail());
	        statement.setLong(3, m.getMobileNumber());
	        statement.setString(4, m.getPassword());
	        statement.setInt(5, m.getId());
	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated == 0) {

	        }
	    } finally {
	        if (statement != null) {
	            statement.close();
	        }
	        if (con != null) {
	        	con.close();
	        }
	    }
	}
	
	public void updateMerchant(Merchant merchant) {
	    try {
	        this.updateMerchantInfo(merchant);
	        List<Product> products = merchant.getProducts();
	        if (products != null && !products.isEmpty()) {
	            ProductDAO productDAO = new ProductDAO(); 
	            for (Product product : products) {
	                productDAO.updateProduct(product);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public void deleteMerchantByID(int id) {
	}

	public Merchant findMerchantById(int id) throws SQLException {
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Merchant where id = ?");
		statement.setInt(1 , id);
		ResultSet resultSet = statement.executeQuery();
		Merchant merchant = new Merchant();

		if(resultSet.next()) {	
			int merchantId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            Long mobileNumber = resultSet.getLong("mobileNumber");
            String password = resultSet.getString("password");
            List<Product> products = fetchMerchantProducts(merchantId);
           
            merchant.setId(merchantId);
            merchant.setName(name);
            merchant.setEmail(email);
            merchant.setMobileNumber(mobileNumber);
            merchant.setPassword(password);
            merchant.setProducts(products);
            
            return merchant;
		}
		
		return null;
	}

	private List<Product> fetchMerchantProducts(int merchantId) throws SQLException {
	    List<Product> products = new ArrayList<>();
	    MerchantProductDAO merchantProductDAO = new MerchantProductDAO();
	    
	    List<Integer> productIds = merchantProductDAO.getProductIdsByMerchantId(merchantId);
	 
	    ProductDAO productDAO = new ProductDAO();
	    for (int productId : productIds) {
	        Product product = productDAO.getProductById(productId);
	        if (product != null) {
	            products.add(product);
	        }
	    }
	    return products;
	}


	public Merchant deleteProductFromMerchant(int merchantId, int productId) {

		return null;
	}

}
