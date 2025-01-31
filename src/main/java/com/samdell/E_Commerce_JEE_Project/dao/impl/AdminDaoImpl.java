package com.samdell.E_Commerce_JEE_Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samdell.E_Commerce_JEE_Project.connection.ConnectionProvider;
import com.samdell.E_Commerce_JEE_Project.dao.AdminDao;
import com.samdell.E_Commerce_JEE_Project.entity.Admin;

public class AdminDaoImpl implements AdminDao{

	Connection conn = ConnectionProvider.getConnection();
	final String getAdminDetailByEmail = "SELECT * FROM admin WHERE email=?";
	
	@Override
	public Admin getAdminByEmailDao(String email) {
		
		try {
			PreparedStatement ps = conn.prepareStatement(getAdminDetailByEmail);
			
			ps.setString(1,email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Admin(rs.getString("email"),rs.getString("password"));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
