package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartTable {

	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	ConnectionDetails c = new ConnectionDetails();
	static int productId;
	int price;
	static String product_name;
	int remQuantity;
	static int selected_quantity;
	int rquantity;
	
//	Create cart table in database
	public void createCartTable() throws ClassNotFoundException, SQLException {
		con = c.callToShopnow();
		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS cart_table" + "(sr_no int auto_increment,"
				+ "username varchar(255)," + "product_id int," + "product_name varchar(255)," + "price int,"
				+ "selected_quantity int," + "PRIMARY KEY(sr_no));");
		ps.execute();
		
	}
	
//	Insert  selected product in cart table
	public void insert() throws ClassNotFoundException, SQLException {
		con = c.callToShopnow();
		
		ps = con.prepareStatement(
				"SELECT product_id, product_name, price, quantity_remaining FROM productlist WHERE product_id =?;");
		ps.setInt(1, ShoppingList.product_id);
		rs = ps.executeQuery();

		while (rs.next()) {
			productId = rs.getInt(1);
			product_name = rs.getString(2);
			price = rs.getInt(3);
			remQuantity = rs.getInt(4);
		}

		con = c.callToShopnow();
		ps = con.prepareStatement(
				"INSERT INTO cart_table (username,product_id,product_name,price,selected_quantity) VALUES (?,?,?,?,?)");
		String username = UserLogin.username;
	
		ps.setString(1, username);
		
		ps.setInt(2, productId);
		ps.setString(3, product_name);
		ps.setInt(4, price);
		ps.setInt(5, ShoppingList.selected_quantity);
		ps.execute();
		
	}
	
//	Truncate cart table
	 public void truncateCart() throws ClassNotFoundException, SQLException {
			
			con = c.callToShopnow();

			ps = con.prepareStatement("TRUNCATE TABLE cart_table;");
			ps.execute();
			
		}
}
