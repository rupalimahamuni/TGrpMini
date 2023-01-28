package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	ConnectionDetails c = new ConnectionDetails();
	ProductTable pt = new ProductTable();

	private final String adminId = "1234";
	private final String adminPass = "1234";

	public String getAdminId() {
		return adminId;
	}

	public String getAdminPass() {
		return adminPass;
	}

//	Verification of admin username and password
	public void verifyAdmin() throws ClassNotFoundException, SQLException {

		String getid;
		String getpass;

		Scanner s = new Scanner(System.in);
		System.out.println("Enter Admin Id: ");
		String id = s.nextLine();

		System.out.println("Enter Admin Password: ");
		String password = s.nextLine();

		AdminLogin al = new AdminLogin();

		getid = al.getAdminId();
		getpass = al.getAdminPass();

		if (id.equals(getid) && password.equals(getpass)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Which list do you want to access?");
			System.out.println("1.Userlist");
			System.out.println("2.Product quantity");
			System.out.println("3.Purchase History by users.");
			int num = sc.nextInt();
			if (num == 1) {
				userList();
			} else if (num == 2) {
				getProductDetails();
			} else if (num == 3) {
				getPurchaseHistory();
			} else {
				System.out.println("Invalid Input");
				System.out.println("________________________________________________");
				verifyAdmin();
			}

		} else {
			System.out.println("Invalid credentials...");
			System.out.println("________________________________________________");
			verifyAdmin();
		}
	}

//  call to userlist table
	public void userList() throws SQLException, ClassNotFoundException {

		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT firstname, lastname, username FROM userlist");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			
			System.out.println("__________________________________________________________________________");
			System.out.println("firstname : " + rs.getString(1));
			System.out.println("lastname : " + rs.getString(2));
			System.out.println("username : " + rs.getString(3));
			System.out.println("__________________________________________________________________________");
		}
	}
	
//	call to productlist table
	public void getProductDetails() throws ClassNotFoundException, SQLException {

		ConnectionDetails details = new ConnectionDetails();
		con = details.callToShopnow();
		ps = con.prepareStatement("SELECT * FROM productlist");
		rs = ps.executeQuery();

		while (rs.next()) {
			
			System.out.println("__________________________________________________________________________");
			System.out.println("Sr_no : "+ rs.getInt(1) );
			System.out.println("Product_Id : " + rs.getInt(2));
			System.out.println("Product_name : " + rs.getString(3));
			System.out.println("Description : " + rs.getString(4));
			System.out.println("Price : " + rs.getInt(5));
			System.out.println("Total Quantity : " + rs.getInt(6));
			System.out.println("Quantity Remaining : " + rs.getInt(7));
			System.out.println("__________________________________________________________________________");
		}
	}
	
//	call to purchase history table
	public void getPurchaseHistory() throws ClassNotFoundException, SQLException {
		
		ConnectionDetails details = new ConnectionDetails();
		con = details.callToShopnow();
		ps = con.prepareStatement("SELECT * FROM purchase_history");
		rs = ps.executeQuery();

		while (rs.next()) {
			
			System.out.println("__________________________________________________________________________");
			System.out.println("Sr_no : "+ rs.getInt(1) );
			System.out.println("Username : " + rs.getString(2));
			System.out.println("Product_id : " + rs.getInt(3));
			System.out.println("Product_name : " + rs.getString(4));
			System.out.println("Price : " + rs.getInt(5));
			System.out.println("Selected_Quantity : " + rs.getInt(6));
			System.out.println("___________________________________________________________________________");
		}
	}
}
