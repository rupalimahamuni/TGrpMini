package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplay {
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;

	public void getProductDetails() throws ClassNotFoundException, SQLException {

		ConnectionDetails details = new ConnectionDetails();
		con = details.callToShopnow();
		ps = con.prepareStatement("SELECT * FROM productlist");

		rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println("ProductId : " + rs.getInt(1));
			System.out.println("Name : " + rs.getString(2));
			System.out.println("Description : " + rs.getString(3));
			System.out.println("Price : " + rs.getInt(4));
			System.out.println("Total Quantity : " + rs.getInt(5));
			System.out.println("Quantity Remaining : " + rs.getInt(6));
			System.out.println("__________");
		}
	}
}
