package com.ECommerce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ECommerce.entity.Product;
import com.ECommerce.utility.ConnectWithDatabase;

public class ProductDAO {
	Connection con;
	private MerchantDAO merchantDAO;
	private List<Product> productList;

	public ProductDAO() {
		this.productList = new ArrayList<>();
		this.merchantDAO = new MerchantDAO();
		this.con = ConnectWithDatabase.getConnection();

	}

	public int saveProduct(Product product) throws SQLException {
		PreparedStatement statement = con.prepareStatement(
				"INSERT INTO Product (brand, category, model, price, stock)" + " VALUES (?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, product.getBrand());
		statement.setString(2, product.getCategory());
		statement.setString(3, product.getModel());
		statement.setDouble(4, product.getPrice());
		statement.setInt(5, product.getStock());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("Creating product failed, no rows affected.");
		}

		try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				int productId = generatedKeys.getInt(1);
				return productId;
			} else {
				throw new SQLException("Creating product failed, no ID obtained.");
			}
		}
	}

	public void updateProduct(Product product) throws SQLException {
		PreparedStatement statement = null;

		try {
			String query = "UPDATE Product SET brand=?, category=?, model=?, price=?, stock=? WHERE id=?";
			statement = con.prepareStatement(query);
			statement.setString(1, product.getBrand());
			statement.setString(2, product.getCategory());
			statement.setString(3, product.getModel());
			statement.setDouble(4, product.getPrice());
			statement.setInt(5, product.getStock());
			statement.setInt(6, product.getId());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0) {
	            throw new SQLException("Product with ID " + product.getId() + " not found");
	        } else {
	            System.out.println("Product with ID " + product.getId() + " updated successfully");
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

	public boolean deleteProductByID(int id) {
		PreparedStatement statement = null;
		try {
			String query = "DELETE FROM Product WHERE id = ?";
			statement = con.prepareStatement(query);
			statement.setInt(1, id);

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Product with ID " + id + " deleted successfully.");
				return true;
			} else {
				System.out.println("Product with ID " + id + " not found for deletion.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Product findProductById(int id) {
		PreparedStatement statement = null;

		try {
			String query = "SELECT * FROM Product WHERE id = ?";
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setModel(rs.getString("model"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				return product;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> fetchAllProduct() {
		List<Product> productList = new ArrayList<Product>();
		PreparedStatement statement = null;
		try {
			String query = "SELECT * FROM Product";
			statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setModel(rs.getString("model"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> findProductByBrand(String brand) {
		return null;

	}

	public Product getProductById(int productId) throws SQLException {
		Product product = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			String query = "SELECT * FROM Product WHERE id = ?";
			statement = con.prepareStatement(query);
			statement.setInt(1, productId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String brand = resultSet.getString("brand");
				String category = resultSet.getString("category");
				String model = resultSet.getString("model");
				double price = resultSet.getDouble("price");
				int stock = resultSet.getInt("stock");

				product = new Product(productId, brand, category, model, price, stock);
			}
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
		}

		return product;
	}
}