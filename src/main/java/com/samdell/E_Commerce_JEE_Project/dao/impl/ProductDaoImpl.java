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
	final String insert_product_detail = "INSERT INTO product(productName,productColor,productQuantity,productPrice,productBrand,productImage,productOwnerId)"
			+ " VALUES(?,?,?,?,?,?,?)";
	
	final String display_all_product_detail = "SELECT * FROM product";
	
	final String get_product_detail_by_ProductOwner_id = "SELECT * FROM product WHERE productOwnerId=?";
	
	final String delete_product_detail = "DELETE FROM product WHERE productId=?";
	
	final String update_product_detail = "UPDATE prodcut SET productName=?, productColor=?, productQuantity=?, productPrice=?, productBrand=?, productImage=? WHERE productId=?";

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
	public List<Product> getProductDetailByProductOwnerIdDao(int productOwnerId) {
		try {
			List<Product> products = new ArrayList<Product>();
			PreparedStatement ps = conn.prepareStatement(get_product_detail_by_ProductOwner_id);
			
			
			ps.setInt(1, productOwnerId);
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
//				System.out.println(product);
				products.add(product);
			}
			
			return products != null ? products : null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public boolean deleteProductDetailDao(int proudctId) {
		try {
			PreparedStatement ps = conn.prepareStatement(delete_product_detail);
			
			ps.setInt(1, proudctId);
			
			int a = ps.executeUpdate();
			
			return a != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public Product updateProductDao(Product product) {
		try {
			PreparedStatement ps = conn.prepareStatement(update_product_detail);
			
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductColor());
			ps.setInt(3, product.getProductQuant());
			ps.setDouble(4, product.getProductPrice());
			ps.setString(5, product.getProductBrand());
			ps.setBytes(6, product.getProductImage());
			
			ps.setInt(7, product.getProductId());
			
			
			int a = ps.executeUpdate();
			
			return a != 0 ? product : null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
