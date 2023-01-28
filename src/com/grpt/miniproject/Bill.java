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

	public void bill() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT product_id, product_name, selected_quantity, price FROM cart_table;");
		rs = ps.executeQuery();
		CartTable ct = new CartTable();
		ShoppingList sl = new ShoppingList();
		
		while (rs.next()) {
			ct.productId = rs.getInt(1);
			ct.product_name = rs.getString(2);
			sl.selected_quantity = rs.getInt(3);
			ct.price = rs.getInt(4);
			multiply = sl.selected_quantity * ct.price;
			total = total + multiply;

			System.out.println("Your bill is : ");
			System.out.println(
					"                _________________________________________________________________________________________________ ");
			System.out.println(
					"               |                                            Shop Now                                             |");
			System.out.println(
					"               |_________________________________________________________________________________________________|");
			System.out.println(
					"               |       Product Id     |         Product Name         |      Quantity  | Price/Qty  |  Total Price|");
			System.out.println("    | " + ct.productId + "    |   " + ct.product_name + "  |  "+sl.selected_quantity + "|" + ct.price + "|" + multiply + "|");
		}

//	    System.out.println("               |______________________|______________________________|________________|____________|_____________|");
//	    System.out.println("               | "+cartProductId+"    |   "+productName+"            |  "+cartSelectedQuantity+"|"+cartPrice+"|"+multiply+"|");
		System.out.println(
				"               |_________________________________________________________________________________________________|");
		System.out.println("               |  Total									" + (total));
//	    
//	    getTotalAmount();
//	    
//	    System.out.println("               |  Customer Instructions: 		"+instruction);
//	    System.out.println("               |_________________________________________________________________________________________________|");
		System.out.println(
				"               |                                       FSSAI - 21518181000281                             ");
		System.out.println(
				"               |_________________________________________________________________________________________________|");
		System.out.println(
				"               |                                      Thank You! Now order online from our                          ");
		System.out.println(
				"               |                                         website www.rollsmania.com                                    ");
		System.out.println(
				"               |_________________________________________________________________________________________________|");

		
		ct.truncateCart();
	}
}
