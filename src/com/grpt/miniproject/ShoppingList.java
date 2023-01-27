package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppingList extends ProductDisplay {
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	int productId;
	int price;
	static String product_name; 
	int remQuantity;
	static String str;
	public static int product_id;
	static int quantity;
	ConnectionDetails c = new ConnectionDetails();
	
	
//	Display Product details on Console from database for user
	@Override
	public void getProductDetails() throws ClassNotFoundException, SQLException {
		
		    con = c.callToShopnow();
			ps = con.prepareStatement("SELECT product_id,product_name,description,price,quantity_remaining FROM productlist ");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ProductId : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Description : "+rs.getString(3));
				System.out.println("Price : "+rs.getInt(4));
				System.out.println("Quantity Remaining : "+rs.getInt(5));
				System.out.println("__________");
				
			}
			createCartTable();
			//selectProduct();
	}
	
//	Create cart table in database
	public void createCartTable() throws ClassNotFoundException, SQLException {
		con = c.callToShopnow();
		ps = con.prepareStatement(
						"CREATE TABLE IF NOT EXISTS cart_table"+
		                "(sr_no int auto_increment,"+
		                "username varchar(255),"+
						"product_id int,"+
						"product_name varchar(255),"+
						"price int,"+
						"selected_quantity int,"+
				        "PRIMARY KEY(sr_no));");
	    int i =	ps.executeUpdate(); 
	    System.out.println("Done....");
	    selectProduct();
}

//	Select product from the Product list table
	public void selectProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("Please Enter Product Id of product which you want to buy...");
		int i = sc.nextInt();
		System.out.println("How many quantity do you want to buy?");
		quantity = sc.nextInt();
		product_id = i;
		
		switch (product_id) {
		case 1:
			insert();
		    break;
			
		case 2:
			insert();
			break;
		case 3:
			insert();
			break;
		case 4:
			insert();
			break;
		case 5:
			insert();
			break;
		case 6:
			insert();
			break;
		case 7:
			insert();
			break;
		case 8:
			insert();
			break;
		case 9:
			insert();
			break;
		case 10:
			insert();
			break;
		default:
			System.out.println("Invalid Input");
		}
				
		System.out.println("Do you want to add another item to cart ?");
		System.out.println("Please enter YES or No");
		Scanner sc1 = new Scanner(System.in);
	    str = sc1.nextLine();
		}
		
		while("YES".equalsIgnoreCase(str));
		
	}		
	
//	Insert  selected product in cart table
	public void insert() throws ClassNotFoundException, SQLException {
		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT product_id, product_name, price, quantity_remaining FROM productlist WHERE product_id =?;");
		ps.setInt(1, product_id);
		rs = ps.executeQuery();
		
		
		while(rs.next()) {
		productId = rs.getInt(1);
		product_name = rs.getString(2);
		price = rs.getInt(3);
		remQuantity = rs.getInt(4);
		}
		
		con = c.callToShopnow();
		ps = con.prepareStatement("INSERT INTO cart_table (username,product_id,product_name,price,selected_quantity) VALUES (?,?,?,?,?)");
		    String username = UserRegistration.username;
		    ps.setString(1, username);
			ps.setInt(2, productId);
			ps.setString(3, product_name);
			ps.setInt(4, price);
			ps.setInt(5, quantity);
		int i = ps.executeUpdate();
		System.out.println("Done");
	}

// Retrieving data from Cart and printing on Console for final billing	
	
	public void fetch() throws ClassNotFoundException, SQLException {
		
		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT product_id, product_name,price FROM cart_table WHERE product_);");
		ps.setInt(1, product_id);
		rs = ps.executeQuery();
		
	} 

}
