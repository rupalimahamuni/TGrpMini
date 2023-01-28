package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {
	
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	ConnectionDetails c = new ConnectionDetails();
	static String username, password;
	
//	Created user table
	public void createUserTable() throws SQLException, ClassNotFoundException {

		con = c.callToShopnow();

		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS userlist" + "(sr_no int auto_increment,"
				+ "firstname varchar(255)," + "lastname varchar(255)," + "username varchar(255),"
				+ "password varchar(255)," + "PRIMARY KEY(sr_no));");
		ps.executeUpdate();

		UserLogin ul = new UserLogin();
		ul.userSignUp();
	}
	

//	User details inserted
	public void userRegistration(String firstName, String lastName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		username = userName;
		con = c.callToShopnow();
		ps = con.prepareStatement("INSERT INTO userlist (firstname, lastname, username, password) VALUES (?,?,?,?)");

		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, password);

		int i = ps.executeUpdate();
		System.out.println("Record updated...");
	}
}
