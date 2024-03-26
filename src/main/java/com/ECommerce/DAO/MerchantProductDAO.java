package com.ECommerce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ECommerce.entity.MerchantProduct;
import com.ECommerce.utility.ConnectWithDatabase;

public class MerchantProductDAO {
	
	Connection con;

	public MerchantProductDAO() {
		super();
		this.con = ConnectWithDatabase.getConnection();

	}

	 public void addMerchantProduct(MerchantProduct merchantProduct) throws SQLException {
	        String sql = "INSERT INTO merchant_product (merchant_id, products_id) VALUES (?, ?)";
	        
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setInt(1, merchantProduct.getMerchantId());
	            statement.setInt(2, merchantProduct.getProductId());
	            
	            statement.executeUpdate();
	        }
	    }

		public List<Integer> getProductIdsByMerchantId(int merchantId) throws SQLException {
	        List<Integer> productIds = new ArrayList<Integer>();
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        
	        try {
	            String query = "SELECT products_id FROM merchant_product WHERE Merchant_id = ?";
	            statement = con.prepareStatement(query);
	            statement.setInt(1, merchantId);
	            resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {
	                int productId = resultSet.getInt("products_id");
	                productIds.add(productId);
	            }
	        } finally {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	        }
	        
	        return productIds;
	    }
	}