package com.samdell.E_Commerce_JEE_Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samdell.E_Commerce_JEE_Project.connection.ConnectionProvider;
import com.samdell.E_Commerce_JEE_Project.dao.ProductDao;
import com.samdell.E_Commerce_JEE_Project.entity.Product;

public class ProductDaoImpl implements ProductDao{
	
	Connection conn = ConnectionProvider.getConnection();
	String insert_product_detail = "INSERT INTO product(productName,productColor,productQuantity,productPrice,productBrand,productImage,productOwnerId)"
			+ " VALUES(?,?,?,?,?,?,?)";
	
	String display_all_product_detail = "SELECT * FROM product";
	
	String get_product_detail_by_id = "SELECT * FROM WHERE id=?";

	@Override
	public Product saveProductDetailDao(Product product) {
		
		try {
			PreparedStatement ps = conn.prepareStatement(insert_product_detail);
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductColor());
			ps.setInt(3, product.getProductQuant());
			ps.setDouble(4, product.getProductPrice());
			ps.setString(5, product.getProductBrand());
			ps.setBytes(6, product.getProductImage());
			ps.setInt(7, product.getProductOwnerId());
			
			int a = ps.executeUpdate();
			
			return a != 0 ? product : null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}



	@Override
	public List<Product> displayAllProductDetailDao() {
		try {
			PreparedStatement ps = conn.prepareStatement(display_all_product_detail);
			List<Product> products = new ArrayList<Product>();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Product product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductColor(rs.getString("productColor"));
				product.setProductQuant(rs.getInt("productQuantity"));
				product.setProductPrice(rs.getDouble("productPrice"));
				product.setProductBrand(rs.getString("productBrand"));
				product.setProductImage(rs.getBytes("productImage"));
				
				products.add(product);
				
			}
			
			return products != null ? products : null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public Product getProductDetailByIdDao(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(get_product_detail_by_id);
			Product product = new Product();
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductColor(rs.getString("productColor"));
				product.setProductQuant(rs.getInt("productQuantity"));
				product.setProductPrice(rs.getDouble("productPrice"));
				product.setProductBrand(rs.getString("productBrand"));
				product.setProductImage(rs.getBytes("productImage"));
				
			}
			
			return product != null ? product : null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
