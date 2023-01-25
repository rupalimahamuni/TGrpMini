package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminData {
	
	PreparedStatement ps = null;
	Connection con = null;

	public void verifyAdmin() {
		
		String getid;
		String getpass;
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Admin Id: ");
		String id = s.nextLine();
		
		System.out.println("Enter Admin Password: ");
		String password = s.nextLine();
		
		AdminLogin al = new AdminLogin();
		 
		getid= al.getAdminId();
		getpass= al.getAdminPass();
		
		if(id.equals(getid) && password.equals(getpass)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Which list do you want to access?");
			System.out.println("1.Userlist");		
			System.out.println("2.Product quantity");
			System.out.println("3.Purchase History by users.");
			int num =sc.nextInt();
			if(num==1) {
				userList();
			}
			else if(num == 2) {
				System.out.println("2");
			}
			else if(num == 3) {
				System.out.println("3");
			}
			else {
				System.out.println("Invalid Input");
			}
			
		}
		else {
			System.out.println("Invalid");
		}
	}
	public void userList() {
try {
			
			ConnectionDetails deatails = new ConnectionDetails();
			con = deatails.getConnectionDetails();
			ps = con.prepareStatement("SELECT sr_no, firstname, lastname, username FROM users");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("sr_no : "+rs.getInt(1));
				System.out.println("firstname : "+rs.getString(2));
				System.out.println("lastname : "+rs.getString(3));
				System.out.println("username : "+rs.getString(4));
				System.out.println("__________");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
    	
    	AdminData ad = new AdminData();
    	ad.verifyAdmin();
    }
}
