package com.grpt.miniproject.user_shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.grpt.miniproject.ConnectionDetails;


public class Cart{
	static int product_id1;
	static String name;
	static int  price;
	static int quantity_remaining;
	
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement ps = null;
	ConnectionDetails c = new ConnectionDetails();
	ShoppingList sl = new ShoppingList();
	
	
	public void createCartTable() throws ClassNotFoundException, SQLException {
			con = c.callToShopnow();
			ps = con.prepareStatement(
							"CREATE TABLE IF NOT EXISTS cart_table"+
							"(product_id int,"+
							"name varchar(255),"+
							"price int,"+
							"selected_quantity int);");
		    int i =	ps.executeUpdate(); 
	}

	public void chooseProduct() throws ClassNotFoundException, SQLException {
		
			con = c.callToShopnow();
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =?; ");
			ps.setInt(1,sl.product_id );
			rs = ps.executeQuery();
			while(rs.next()) {
			product_id1 = rs.getInt(1);
			name = rs.getString(2);
			price = rs.getInt(3);
			System.out.println(product_id1+name+price);
			}
//			inserCartTable();	
	}
	
	
		public void inserCartTable() throws ClassNotFoundException, SQLException {
	
				con = c.callToShopnow();
				ps = con.prepareStatement("INSERT INTO cart_table(product_id,name,price,selected_quantity) VALUES (?,?,?,?)");
			    ps.setInt(1, product_id1);
			    ps.setString(2, name);
			    ps.setInt(3, price);
			    ps.setInt(4,sl.quantity);
				int i =	ps.executeUpdate();   
		}
		
	}

