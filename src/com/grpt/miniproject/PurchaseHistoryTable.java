package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseHistoryTable {

	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	ConnectionDetails c = new ConnectionDetails();
	
//	User purchase history table created
	public void purchaseHistory() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();

		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS purchase_history" + "(sr_no int,"
				+ "username varchar(255)," + "product_id int," + "product_name varchar(255)," + "price int,"
				+ "selected_quantity int);");
		ps.executeUpdate();
	}

	
//	Insert data into purchase history table
	public void insertHistory() throws SQLException, ClassNotFoundException {

		con = c.callToShopnow();

		ps = con.prepareStatement(
				"INSERT INTO purchase_history (username, product_id, product_name, price, selected_quantity) SELECT username, product_id, product_name, price, selected_quantity FROM cart_table GROUP BY sr_no");
		ps.executeUpdate();
	}
}
