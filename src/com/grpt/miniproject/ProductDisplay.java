package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDisplay {
	PreparedStatement ps = null;
	Connection con = null;
	
	public void getProductDetails() {
		try {
			
			ConnectionDetails deatails = new ConnectionDetails();
			con = deatails.getConnectionDetails();
			ps = con.prepareStatement("SELECT * FROM products");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ProductId : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Description : "+rs.getString(3));
				System.out.println("Price : "+rs.getInt(4));
				System.out.println("Quantity : "+rs.getInt(5));
				System.out.println("__________");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
