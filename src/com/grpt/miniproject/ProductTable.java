package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductTable {
	PreparedStatement ps = null;
	Connection con = null;
	
	public void createUserTable() {

		try {
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			ps = con.prepareStatement("CREATE schema shopnow;");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow","root","root");
			ps = con.prepareStatement(
							"CREATE TABLE userlist"+
							"(sr_no int primary key auto_increment,"+
							"firstname varchar(255),"+
							"lastname varchar(255),"+
							"username varchar(255),"+
							"password varchar(255));");
		    int i =	ps.executeUpdate();
		
			System.out.println("done");
		}
			catch (Exception e) {
				e.printStackTrace();			
	}
   }
	
	public void createProductTable() {
        try {
			ConnectionDetails details = new ConnectionDetails();
			con = details.getConnectionDetails();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow","root","root");
			ps = con.prepareStatement(
							"CREATE TABLE productlist"+
							"(product_id int  primary key auto_increment,"+
							"name varchar(255),"+
							"description varchar(255),"+
							"price int,"+
							"total_quantity int,"+
							"quantity_remaining int);");
		    int i =	ps.executeUpdate();
		
			System.out.println("done");
		}
			catch (Exception e) {
				e.printStackTrace();				
	    }	
	}
	
	public void insertProductDetails() {
		try {
		ConnectionDetails details = new ConnectionDetails();
		con = details.getConnectionDetails();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopnow","root","root");
		ps = con.prepareStatement(
						"INSERT INTO productlist (product_id,name,description,price,total_quantity,quantity_remaining) VALUES  "
						+ "(1,'Samsung Galaxy F13',	'RAM - 4GB, Camera - 50MP, Battery - 6000mAh, Processor - Exynos850',12000,10,10),"
						+ "(2,'Mi Telivision','Mi 5A 108 cm (43 inch) Full HD LED Smart Android TV with Dolby Audio (2022 Model)',25000,10,10),"
						+ "(3,'BoAt Stone Bluetooth Speaker','1200 14W, WaterProof, Total 15hrs playback',4000,10,10),"
						+ "(4,'Samsung Refrigerator', 'SAMSUNG 253 L Frost Free Double Door 3 Star Convertible Refrigerator',24000,10,10),"
						+ "(5,'ASUS Vivobook Pro 15','16 GB/512 GB SSD/Windows 11 Home/4 GB ,15.6 Inch, Cool Silver',59000,10,10),"
						+ "(6,'Noise Colorfit','1.69 inch HD Display, 60 Porch mode, spO2 monitoring',1500,10,10),"
						+ "(7,'Hair Dryer','1000 watt, Cordless & Compact, 1.5m power cord, 2 years warranty',900,10,10),"
						+ "(8,'Mivi DuoPods M30 earbuds','42 hours of playtime, Deep Bass Bluetooth Headset,True Wireless',1000,10,10),"
						+ "(9,'Zebronics blueetooth EarHeadPhone','9hrs playback, call function, adjustable headband',600,10,10),"
						+ "(10,'Voltas AC','1.5 Ton 5 Star Split Inverter White, Copper Condenser',38000,10,10);");
	    int i =	ps.executeUpdate();
	
		System.out.println("done");
	 }
		catch (Exception e) {
			e.printStackTrace();				
     }		
	}
	
	
	public static void main(String[] args) {
		ProductTable productTable = new ProductTable();
		//productTable.createProductTable();
		//productTable.createUserTable();
		productTable.insertProductDetails();
	}
	}

