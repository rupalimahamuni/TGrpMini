package com.grpt.miniproject;


public class Main {

	public static void main(String[] args) {
	
		ConnectionDetails c = new ConnectionDetails();
	        try {
				c.createSchema();
			}
	        catch(Exception e) {
				e.printStackTrace();
			}
	}
}
