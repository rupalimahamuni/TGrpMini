package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;




public class UserRegistration {
	
	PreparedStatement ps = null;
	Connection con = null;
	static String username,password;
	
	
	public void userRegistration(String firstName, String lastName, String username, String password ) {
	
		try {
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			ps = con.prepareStatement("INSERT INTO users (firstname, lastname, username, password) VALUES (?,?,?,?)");
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, username);
			ps.setString(4, password);
			
			int i = ps.executeUpdate();
			System.out.println("Record updated...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userSignUp() {
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("Are you New Customer ? Please write YES or NO ");
		String str = sc.nextLine();
		if("YES".equalsIgnoreCase(str)) {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter FirstName ");
		String str1 = sc1.nextLine();
		
		System.out.println("Enter LastName ");
		String str2 = sc1.nextLine();
		
		System.out.println("Enter Username ");
		String str3 = sc1.nextLine();
		
		System.out.println("Enter Password ");
		String str4 = sc1.nextLine();
		userRegistration(str1, str2, str3, str4);
	}else {
		userLogin();
	}
	}
	
	
	
	public void userLogin() {
		
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username ");
		username = sc.nextLine();
		
		System.out.println("Enter Password ");
		password = sc.nextLine();
		
		try {
			
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			ps = con.prepareStatement("Select password from users where username  = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String dbPassword = rs.getString("password");	
				if((password.equals(dbPassword))) {
			
				System.out.println("checked");
			}
			else {
				System.out.println("invalid");
			}
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	

	
	public void adminLogin() {
	
		
	}

	public static void main(String[] args) {
		
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.userSignUp();
	}

	
	public void signUp() {
		
		
	}


}
