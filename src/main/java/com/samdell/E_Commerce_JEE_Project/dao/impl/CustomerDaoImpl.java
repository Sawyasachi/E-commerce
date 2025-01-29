package com.samdell.E_Commerce_JEE_Project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.samdell.E_Commerce_JEE_Project.connection.ConnectionProvider;
import com.samdell.E_Commerce_JEE_Project.dao.CustomerDao;
import com.samdell.E_Commerce_JEE_Project.entity.Customer;

public class CustomerDaoImpl implements CustomerDao{
	Connection conn = ConnectionProvider.getConnection();
	String insertCustomerQuery = "INSERT INTO customer(name,email,password,image) VALUES(?,?,?,?)";

	@Override
	public Customer saveCustomerDetailDao(Customer customer) {
		try {
			PreparedStatement ps = conn.prepareStatement(insertCustomerQuery);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmail());
			ps.setString(3, customer.getCustomerPassword());
			ps.setBytes(4, customer.getCustomerImage());
			
			int a = ps.executeUpdate();
			
			return a != 0 ? customer:null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
