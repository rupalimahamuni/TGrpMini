package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bill {

	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	ConnectionDetails c = new ConnectionDetails();
	int  multiply;
	int total;
	
//	Display final bill	
	public void bill() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT product_id, product_name, selected_quantity, price FROM cart_table;");
		rs = ps.executeQuery();
		CartTable ct = new CartTable();
		
		System.out.println("                _________________________________________________________________________________________________ ");
		System.out.println("               |                                            Shop Now                                             |");
		System.out.println("               |_________________________________________________________________________________________________|");
		System.out.println("               |       Product Id     |         Product Name    |      Quantity  | Price     |  Total Price      |");
		System.out.println("               |_________________________________________________________________________________________________|");
		
		while (rs.next()) {
			CartTable.productId = rs.getInt(1);
			CartTable.product_name = rs.getString(2);
			ShoppingList.selected_quantity = rs.getInt(3);
			ct.price = rs.getInt(4);
			multiply = ShoppingList.selected_quantity * ct.price; 
			total = total + multiply;

			
			System.out.println("               |     "+CartTable.productId+    "                "+CartTable.product_name+  "                 "+ShoppingList.selected_quantity+  "           "+ct.price+   "         "+ multiply   );
		}
		
		System.out.println("               |_________________________________________________________________________________________________|");
		System.out.println("               |    Total									  " + (total)+"          |");
		System.out.println("               |_________________________________________________________________________________________________|");
		System.out.println("               |                                      Thank You! Order online from our                            ");
		System.out.println("               |                                         website www.shopnow.com                                  ");
		System.out.println("               |_________________________________________________________________________________________________|");

		ct.truncateCart();
	}
}
