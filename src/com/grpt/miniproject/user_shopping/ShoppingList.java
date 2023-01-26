package com.grpt.miniproject.user_shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	List list =  new ArrayList();
	@Override
	public void getProductDetails() {
		try {
			
			ConnectionDetails deatails = new ConnectionDetails();
			con = deatails.getConnectionDetails();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow","root","root");
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
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		selectProduct();
	}
	
	public void selectProduct() {
		Scanner sc = new Scanner(System.in);
		Cart c = new Cart();
		do {
		System.out.println("Please Enter Product Id of product which you want to buy...");
		int i = sc.nextInt();
		
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow","root","root");
		switch (i) {
		
		case 1:
			
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =1; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list +"\n");
	

			break;
			
		case 2:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =2; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list+"\n");
			break;
		case 3:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =3; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 4:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =4; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 5:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =5; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 6:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =6; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 7:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =7; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 8:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =8; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 9:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =9; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		case 10:
			ps = con.prepareStatement("SELECT product_id,name,price FROM productlist WHERE product_id =10; ");
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			}
			System.out.println(list);
			break;
		default:
			System.out.println("Invalid Input");
		}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		Cart c1 = new Cart();
		c1.addToCart();
		System.out.println("Do you want to add another item to cart ?");
		System.out.println("Please enter YES or No");
		Scanner sc1 = new Scanner(System.in);
	    str = sc1.nextLine();
		}
		
		while("YES".equalsIgnoreCase(str));
		
	}		
}

