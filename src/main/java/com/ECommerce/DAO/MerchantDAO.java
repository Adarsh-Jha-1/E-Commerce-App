package com.ECommerce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ECommerce.entity.Merchant;
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


	public void updateMerchant(Merchant m) {

	}

	public void deleteMerchantByID(int id) {
	}

	public Merchant findMerchantById(int id) {
		return null;

	}

	public Merchant deleteProductFromMerchant(int merchantId, int productId) {

		return null;
	}

}
