package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppingList {
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	int productId;
	int price;
	static String product_name;
	int remQuantity;
	static String str;
	public static int product_id;
	static int selected_quantity;
	int rquantity;
	ConnectionDetails c = new ConnectionDetails();
	Connection shopNowCon = null;
	int cartProductId,cartSelectedQuantity,cartPrice,multiply;
	String productName;
	int total;
	
//	Display Product details on Console from database for user
	
	public void getProductDetails() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();
		ps = con.prepareStatement(
				"SELECT product_id,product_name,description,price,quantity_remaining FROM productlist ");
		rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println("ProductId : " + rs.getInt(1));
			System.out.println("Name : " + rs.getString(2));
			System.out.println("Description : " + rs.getString(3));
			System.out.println("Price : " + rs.getInt(4));
			System.out.println("Quantity Remaining : " + rs.getInt(5));
			System.out.println("__________");

		}
			selectProduct();
	}

//	Select product from the Product list table
	public void selectProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		CartTable cart = new CartTable();
		cart.createCartTable();
		PurchaseHistoryTable pht = new PurchaseHistoryTable();
		pht.purchaseHistory();

		do {
			System.out.println("Please Enter Product Id of product which you want to buy...");
			int i = sc.nextInt();
			System.out.println("How many quantity do you want to buy?");
			selected_quantity = sc.nextInt();
			product_id = i;
			
			switch (product_id) {
			case 1:
				cart.insert();
				updatequatity();
				break;
			case 2:
				cart.insert();
				updatequatity();
				break;
			case 3:
				cart.insert();
				updatequatity();
				break;
			case 4:
				cart.insert();
				updatequatity();
				break;
			case 5:
				cart.insert();
				updatequatity();
				break;
			case 6:
				cart.insert();
				updatequatity();
				break;
			case 7:
				cart.insert();
				updatequatity();
				break;
			case 8:
				cart.insert();
				updatequatity();
				break;
			case 9:
				cart.insert();
				updatequatity();
				break;
			case 10:
				cart.insert();
				updatequatity();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("Do you want to add another item to cart ?");
			System.out.println("Please enter YES or No");
			Scanner sc1 = new Scanner(System.in);
			str = sc1.nextLine();
		}

		while ("YES".equalsIgnoreCase(str));
		pht.insertHistory();
		Bill b = new Bill();
		b.bill();
	}

//	Update remaining quantity into Product list table
	public void updatequatity() throws ClassNotFoundException, SQLException {
		
		shopNowCon = c.callToShopnow();
		ps = shopNowCon.prepareStatement("SELECT quantity_remaining FROM productlist WHERE product_id = ?");
		ps.setInt(1, product_id);
		ps.execute();
		
		rs = ps.executeQuery();
		while(rs.next()) {
		 rquantity= rs.getInt(1);
		}
		
		rquantity = rquantity- selected_quantity;
		
		ps = shopNowCon.prepareStatement("UPDATE productlist SET quantity_remaining = ? WHERE  product_id = ?");
		ps.setInt(1, rquantity);
		
		ps.setInt(2, product_id);
		ps.execute();
	}
}
