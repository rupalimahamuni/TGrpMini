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

	@Override
	public String toString() {
		return "AdminLogin [adminId=" + adminId + ", adminPass=" + adminPass + "]";
	}
	
	

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
				PurchaseHistoryTable pht = new PurchaseHistoryTable();
				pht.insertHistory();
			} else {
				System.out.println("Invalid Input");
			}

		} else {
			System.out.println("Invalid");
		}
	}

	public void userList() throws SQLException, ClassNotFoundException {

		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT firstname, lastname, username FROM userlist");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println("firstname : " + rs.getString(1));
			System.out.println("lastname : " + rs.getString(2));
			System.out.println("username : " + rs.getString(3));
			System.out.println("__________");
		}
	}
	
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
