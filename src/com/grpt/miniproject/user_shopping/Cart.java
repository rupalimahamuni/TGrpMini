package com.grpt.miniproject.user_shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.grpt.miniproject.ConnectionDetails;


public class Cart {
	Connection con = null;
	PreparedStatement ps = null;
	ConnectionDetails c = new ConnectionDetails();
	
	
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
	
		public void inserCartTable() throws ClassNotFoundException, SQLException {
	
				con = c.callToShopnow();
				ps = con.prepareStatement("INSERT INTO cart_table() VALUES (?)");
			  
				int i =	ps.executeUpdate();   
		}
		
	}

