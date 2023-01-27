package com.grpt.miniproject.user_shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.grpt.miniproject.ConnectionDetails;
import com.grpt.miniproject.ProductDisplay;

public class ShoppingList extends ProductDisplay {
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	static String str;
	static int product_id;
	static int quantity;
	
	
	ConnectionDetails c = new ConnectionDetails();
	Cart cs = new Cart();
	@Override
	public void getProductDetails() throws ClassNotFoundException, SQLException {
		
		    con = c.callToShopnow();
			ps = con.prepareStatement("SELECT product_id,name,description,price,quantity_remaining FROM productlist ");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ProductId : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Description : "+rs.getString(3));
				System.out.println("Price : "+rs.getInt(4));
				System.out.println("Quantity Remaining : "+rs.getInt(5));
				System.out.println("__________");
				
			}
						
		selectProduct();
	}
	
	
	public void chooseProduct() throws ClassNotFoundException, SQLException {
		
			con = c.callToShopnow();
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =?; ");
			ps.setInt(1,product_id );
			rs = ps.executeQuery();
			while(rs.next()) {
			
			}
	}
	
	public void selectProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Cart c = new Cart();
		do {
		System.out.println("Please Enter Product Id of product which you want to buy...");
		int i = sc.nextInt();
		System.out.println("How many quantity do you want to buy?");
		quantity = sc.nextInt();
		product_id = i;
		
		switch (product_id) {
		case 1:
			chooseProduct();
		    break;
			
		case 2:
			chooseProduct();
			break;
		case 3:
			chooseProduct();
			break;
		case 4:
			chooseProduct();
			break;
		case 5:
			chooseProduct();
			break;
		case 6:
			chooseProduct();
			break;
		case 7:
			chooseProduct();
			break;
		case 8:
			chooseProduct();
			break;
		case 9:
			chooseProduct();
			break;
		case 10:
			chooseProduct();
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
}

