package com.samdell.E_Commerce_JEE_Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.samdell.E_Commerce_JEE_Project.connection.ConnectionProvider;
import com.samdell.E_Commerce_JEE_Project.dao.ProductOwnerDao;
import com.samdell.E_Commerce_JEE_Project.entity.ProductOwner;

public class ProductOwnerDaoImpl implements ProductOwnerDao{
	
	Connection conn = ConnectionProvider.getConnection();
	final String insertProductOwnerQuery  = "INSERT INTO product_owner(name,email,password,verify) VALUES(?,?,?,?)";
	final String getProductOwnerByEmail = "SELECT * FROM product_owner WHERE email=?";
	
	final String getAllNonVerifiedProductOwnerDetail = "SELECT * FROM product_owner WHERE verify='no'";
	final String getAllVerifiedProductOwnerDetail = "SELECT * FROM product_owner WHERE verify='yes'";
	
	final String verify_product_owner_Detail = "UPDATE product_owner SET verify=? WHERE id=?";
	
	final String update_product_owner_detail = "UPDATE product_owner SET name=?, email=? WHERE id=?";

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
				
				productOwner.setProductOwnerId(rs.getInt("id"));
				productOwner.setProductOwnerName(rs.getString("name"));
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
	public List<ProductOwner> getAllNonVerifiedProductOwnerDao() {
		try {
			Statement statement = conn.createStatement();
			ResultSet set=statement.executeQuery(getAllNonVerifiedProductOwnerDetail);
			
			List<ProductOwner> owners = new ArrayList<ProductOwner>();
			while(set.next()) {
				
				ProductOwner owner = 
						new ProductOwner(set.getInt("id"),
						set.getString("name"),
						set.getString("email"),
						set.getString("verify")
						);
				owners.add(owner);
				
			}
			return owners;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean verifyProductOwnerDao(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(verify_product_owner_Detail);
			
			ps.setString(1, "yes");
			ps.setInt(2, id);
			
			int a = ps.executeUpdate();
			
			return a != 0 ? true :false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ProductOwner> getAllVerifiedProductOwnerDao() {
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(getAllVerifiedProductOwnerDetail);
			
			List<ProductOwner> owners = new ArrayList<ProductOwner>();
			while(rs.next()) {
				
				ProductOwner owner = new ProductOwner(rs.getInt("id"),
													  rs.getString("name"),
													  rs.getString("email"),
													  rs.getString("verify"));
				
				owners.add(owner);
			}
			
			return owners;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean unVerifiedProductOwnerDao(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement(verify_product_owner_Detail);
			
			ps.setString(1, "no");
			ps.setInt(2, id);
			
			int a = ps.executeUpdate();
			
			return a != 0 ? true :false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProductOwnerDetail(ProductOwner productOwner) {
		try {
			PreparedStatement ps = conn.prepareStatement(update_product_owner_detail);
			
			ps.setString(1, productOwner.getProductOwnerName());
			ps.setString(2, productOwner.getProductOwnerEmail());
			ps.setInt(3, productOwner.getProductOwnerId());
			
			int a = ps.executeUpdate();
			
			return a != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
