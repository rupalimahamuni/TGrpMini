package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDetails {

	PreparedStatement ps = null;
	Connection sysCon = null;
	Connection shopNowCon = null;

	public Connection getConnectionDetails() throws ClassNotFoundException, SQLException {
		if (null == sysCon) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			sysCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		}
		return sysCon;
	}

	public void createSchema() throws ClassNotFoundException, SQLException {
		Connection con = getConnectionDetails();
		ps = con.prepareStatement("CREATE schema IF NOT EXISTS shopnow;");
		ps.executeUpdate();
		ProductTable pt = new ProductTable();
		pt.createProductTable();

	}

	public Connection callToShopnow() throws ClassNotFoundException, SQLException {
		if (null == shopNowCon) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			shopNowCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow", "root", "root");
		}
		return shopNowCon;
	}
}
