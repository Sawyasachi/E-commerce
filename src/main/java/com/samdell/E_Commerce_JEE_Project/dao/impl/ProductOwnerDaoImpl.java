package com.samdell.E_Commerce_JEE_Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samdell.E_Commerce_JEE_Project.connection.ConnectionProvider;
import com.samdell.E_Commerce_JEE_Project.dao.ProductOwnerDao;
import com.samdell.E_Commerce_JEE_Project.entity.ProductOwner;

public class ProductOwnerDaoImpl implements ProductOwnerDao{
	
	Connection conn = ConnectionProvider.getConnection();
	final String insertProductOwnerQuery  = "INSERT INTO product_owner(name,email,password,verify) VALUES(?,?,?,?)";
	final String getProductOwnerByEmail = "SELECT * FROM product_owner WHERE email=?";
	
	final String getProductOwnerDetailById = "SELECT * FROM product_owner WHERE id=?";

	@Override
	public ProductOwner registerProductOwnerDetailDao(ProductOwner productOwner) {
		
		try {
			PreparedStatement ps = conn.prepareStatement(insertProductOwnerQuery);
			
			ps.setString(1, productOwner.getProductOwnerName());
			ps.setString(2, productOwner.getProductOwnerEmail());
			ps.setString(3, productOwner.getProductOwnerPassword());
			ps.setString(4, "No");
			
			int a = ps.executeUpdate();
			
			return a != 0 ? productOwner : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public ProductOwner getProductOwnerByEmailDao(String email) {
		try {
			PreparedStatement ps = conn.prepareStatement(getProductOwnerByEmail);
			
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ProductOwner productOwner = new ProductOwner();
				
				productOwner.setProductOwnerEmail(rs.getString("email"));
				productOwner.setProductOwnerPassword(rs.getString("password"));
				productOwner.setProductOwnerVerify(rs.getString("verify"));
				
				return productOwner;
				
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductOwner getProductOwnerDetailByProductOwnerId(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(getProductOwnerDetailById);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return new ProductOwner(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getString("verify"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
