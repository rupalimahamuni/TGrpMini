package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDetails {
	
	PreparedStatement ps = null;
	Connection con = null;
	
	public Connection getConnectionDetails() {
    try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
public void createSchema() {
		
		try {
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","root");
			ps = con.prepareStatement("CREATE schema IF NOT EXISTS shopnow;");
			ps.executeUpdate();
			ProductTable pt = new ProductTable();
			pt.createProductTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	     }	

public Connection callToShopnow() {
	
	try {
		ConnectionDetails details = new ConnectionDetails();
		con = details.getConnectionDetails();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow","root","root");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
    }
	}
	
