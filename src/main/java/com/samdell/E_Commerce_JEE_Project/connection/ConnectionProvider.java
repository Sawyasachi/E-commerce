package com.samdell.E_Commerce_JEE_Project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionProvider {

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			String username = "root";
			String password = "root@3690";
			String url = "jdbc:mysql://127.0.0.1:3306/e-commerce";

			conn = DriverManager.getConnection(url, username, password);
			if (conn != null) {
				return conn;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
