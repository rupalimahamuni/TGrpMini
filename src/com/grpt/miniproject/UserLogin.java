package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {

	PreparedStatement ps = null;
	Connection con = null;
	static String username, password;
	ConnectionDetails c = new ConnectionDetails();
	ShoppingList sl = new ShoppingList();

	
//  User sign up method
	public void userSignUp() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("__________________________________________________________________");
		System.out.println("Are you Admin or Customer?");
		String string = sc.nextLine();
		if ("Admin".equalsIgnoreCase(string)) {
			AdminLogin al = new AdminLogin();
			al.verifyAdmin();
		} else if ("Customer".equalsIgnoreCase(string)) {
			System.out.println("__________________________________________________________________");
			System.out.println("Are you New Customer ? Please write YES or NO ");
			String str = sc.nextLine();
			if ("YES".equalsIgnoreCase(str)) {

				Scanner sc1 = new Scanner(System.in);
				System.out.println("__________________________________________________________________");
				System.out.println("Please sign up...");
				
				System.out.println("Enter your First Name ");
				String str1 = sc1.nextLine();

				System.out.println("Enter your Last Name ");
				String str2 = sc1.nextLine();

				System.out.println("Enter Username ");
				String str3 = sc1.nextLine();

				System.out.println("Set Password ");
				String str4 = sc1.nextLine();
				UserTable ut = new UserTable();
				ut.userRegistration(str1, str2, str3, str4);
				userLogin();
				
			} else {

				userLogin();
			}
		} else {
			System.out.println("Invalid input");
			System.out.println("Please enter correct option");
			System.out.println("__________________________________________________________");
			userSignUp();
		}

	}

//  User login method
	public void userLogin() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("______________________________________________________________");
		System.out.println("Welcome to SHOP NOW !!");
		System.out.println("Please enter your login credentials....");
		System.out.println("______________________________________________________________");
		System.out.println("Enter Username ");
		username = sc.nextLine();

		System.out.println("Enter Password ");
		password = sc.nextLine();

		con = c.callToShopnow();
		ps = con.prepareStatement("Select password from userlist where username  = ?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String dbPassword = rs.getString("password");
			if ((password.equals(dbPassword))) {

				System.out.println("________________________________________________________________________");
				System.out.println("_________________________PRODUCT DETAILS _______________________________");
				sl.getProductDetails();
			} else {
				System.out.println("Invalid Password....");
				userLogin();
			}
		}
	}

}
