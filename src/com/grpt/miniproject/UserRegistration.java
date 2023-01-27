package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {

	PreparedStatement ps = null;
	Connection con = null;
	static String username, password;
	ConnectionDetails c = new ConnectionDetails();
	ShoppingList sl = new ShoppingList();

	public void userRegistration(String firstName, String lastName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		username = userName;
		con = c.callToShopnow();
		ps = con.prepareStatement("INSERT INTO userlist (firstname, lastname, username, password) VALUES (?,?,?,?)");

		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, password);

		int i = ps.executeUpdate();
		System.out.println("Record updated...");
		sl.getProductDetails();

	}

	public void userSignUp() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Are you Admin or Customer?");
		String string = sc.nextLine();
		if ("Admin".equalsIgnoreCase(string)) {
			AdminData adminData = new AdminData();
			adminData.verifyAdmin();
		} else if ("Customer".equalsIgnoreCase(string)) {
			System.out.println("Are you New Customer ? Please write YES or NO ");
			String str = sc.nextLine();
			if ("YES".equalsIgnoreCase(str)) {

				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter FirstName ");
				String str1 = sc1.nextLine();

				System.out.println("Enter LastName ");
				String str2 = sc1.nextLine();

				System.out.println("Enter Username ");
				String str3 = sc1.nextLine();

				System.out.println("Enter Password ");
				String str4 = sc1.nextLine();
				// sl.createCartTable();
				userLogin();
				userRegistration(str1, str2, str3, str4);
			} else {
				// sl.createCartTable();
				userLogin();
			}
		} else {
			System.out.println("Invalid input");
		}

	}

	public void userLogin() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Username ");
		username = sc.nextLine();

		System.out.println("Enter Password ");
		password = sc.nextLine();

		con = c.callToShopnow();
		ps = con.prepareStatement("Select password from userlist where username  = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		System.out.println(username);

		while (rs.next()) {
			String dbPassword = rs.getString("password");
			if ((password.equals(dbPassword))) {

				System.out.println("checked");
				sl.getProductDetails();
			} else {
				System.out.println("invalid");
				userLogin();
			}
		}
	}

}
