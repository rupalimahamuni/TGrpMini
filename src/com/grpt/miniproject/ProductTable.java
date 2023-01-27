package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTable {
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	String s;
	ConnectionDetails c = new ConnectionDetails();
	

//	Created user table
	public void createUserTable() throws SQLException, ClassNotFoundException {

		con = c.callToShopnow();

		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS userlist" + "(sr_no int auto_increment,"
				+ "firstname varchar(255)," + "lastname varchar(255)," + "username varchar(255),"
				+ "password varchar(255)," + "PRIMARY KEY(sr_no));");
		ps.executeUpdate();

		UserRegistration userRegistration = new UserRegistration();
		userRegistration.userSignUp();
	}

//	Created Product table
	public void createProductTable() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();

		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS productlist" + "(sr_no int  auto_increment,"
				+ "product_id int," + "product_name varchar(255)," + "description varchar(255)," + "price int,"
				+ "total_quantity int," + "quantity_remaining int," + "PRIMARY KEY(sr_no));");
		ps.executeUpdate();

		insertProductDetails();
	}

//	Product data inserted into ProductList table by default
	public void insertProductDetails() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();

		ps = con.prepareStatement(
				"INSERT IGNORE INTO productlist (sr_no,product_id,product_name,description,price,total_quantity,quantity_remaining) VALUES "
						+ "(1,1,'Samsung Galaxy F13',	'RAM - 4GB, Camera - 50MP, Battery - 6000mAh, Processor - Exynos850',12000,10,10),"
						+ "(2,2,'Mi Telivision','Mi 5A 108 cm (43 inch) Full HD LED Smart Android TV with Dolby Audio (2022 Model)',25000,10,10),"
						+ "(3,3,'BoAt Stone Bluetooth Speaker','1200 14W, WaterProof, Total 15hrs playback',4000,10,10),"
						+ "(4,4,'Samsung Refrigerator', 'SAMSUNG 253 L Frost Free Double Door 3 Star Convertible Refrigerator',24000,10,10),"
						+ "(5,5,'ASUS Vivobook Pro 15','16 GB/512 GB SSD/Windows 11 Home/4 GB ,15.6 Inch, Cool Silver',59000,10,10),"
						+ "(6,6,'Noise Colorfit','1.69 inch HD Display, 60 Porch mode, spO2 monitoring',1500,10,10),"
						+ "(7,7,'Hair Dryer','1000 watt, Cordless & Compact, 1.5m power cord, 2 years warranty',900,10,10),"
						+ "(8,8,'Mivi DuoPods M30 earbuds','42 hours of playtime, Deep Bass Bluetooth Headset,True Wireless',1000,10,10),"
						+ "(9,9,'Zebronics blueetooth EarHeadPhone','9hrs playback, call function, adjustable headband',600,10,10),"
						+ "(10,10,'Voltas AC','1.5 Ton 5 Star Split Inverter White, Copper Condenser',38000,10,10);");
		ps.executeUpdate();

		createUserTable();
	}

//	User purchase history table created
	public void purchaseHistory() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();

		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS purchase_history" + "(username varchar(255),"
				+ "product_id int primary key," + "product_name varchar(255));");
		ps.executeUpdate();
		insertHistory();
	}

//	Insert data into purchase history table
	public void insertHistory() throws SQLException, ClassNotFoundException {

		con = c.callToShopnow();

		ps = con.prepareStatement("INSERT INTO purchase_history (username,product_id,product_name) VALUES(?,?,?);");

		ps.setString(1, UserRegistration.username);
		ps.setInt(2, ShoppingList.product_id);
		ps.setString(3, ShoppingList.product_name);
		ps.executeUpdate();

	}

}
