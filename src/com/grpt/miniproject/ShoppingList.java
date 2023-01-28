package com.grpt.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShoppingList extends ProductDisplay {
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	int productId;
	int price;
	static String product_name;
	int remQuantity;
	static String str;
	public static int product_id;
	static int selected_quantity;
	int rquantity;
	ConnectionDetails c = new ConnectionDetails();
	Connection shopNowCon = null;
	int cartProductId,cartSelectedQuantity,cartPrice,multiply;
	String productName;
	
//	Display Product details on Console from database for user
	@Override
	public void getProductDetails() throws ClassNotFoundException, SQLException {

		con = c.callToShopnow();
		ps = con.prepareStatement(
				"SELECT product_id,product_name,description,price,quantity_remaining FROM productlist ");
		rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println("ProductId : " + rs.getInt(1));
			System.out.println("Name : " + rs.getString(2));
			System.out.println("Description : " + rs.getString(3));
			System.out.println("Price : " + rs.getInt(4));
			System.out.println("Quantity Remaining : " + rs.getInt(5));
			System.out.println("__________");

		}
		createCartTable();
		// selectProduct();
	}

//	Create cart table in database
	public void createCartTable() throws ClassNotFoundException, SQLException {
		con = c.callToShopnow();
		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS cart_table" + "(sr_no int auto_increment,"
				+ "username varchar(255)," + "product_id int," + "product_name varchar(255)," + "price int,"
				+ "selected_quantity int," + "PRIMARY KEY(sr_no));");
		int i = ps.executeUpdate();
		System.out.println("Done....");
		selectProduct();
	}

//	Select product from the Product list table
	public void selectProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Please Enter Product Id of product which you want to buy...");
			int i = sc.nextInt();
			System.out.println("How many quantity do you want to buy?");
			selected_quantity = sc.nextInt();
			product_id = i;

			switch (product_id) {
			case 1:
				insert();
				updatequatity();
				break;
			case 2:
				insert();
				updatequatity();
				break;
			case 3:
				insert();
				updatequatity();
				break;
			case 4:
				insert();
				updatequatity();
				break;
			case 5:
				insert();
				updatequatity();
				break;
			case 6:
				insert();
				updatequatity();
				break;
			case 7:
				insert();
				updatequatity();
				break;
			case 8:
				insert();
				updatequatity();
				break;
			case 9:
				insert();
				updatequatity();
				break;
			case 10:
				insert();
				updatequatity();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("Do you want to add another item to cart ?");
			System.out.println("Please enter YES or No");
			Scanner sc1 = new Scanner(System.in);
			str = sc1.nextLine();
		}

		while ("YES".equalsIgnoreCase(str));
		bill();
	}

//	Insert  selected product in cart table
	public void insert() throws ClassNotFoundException, SQLException {
		con = c.callToShopnow();
		ps = con.prepareStatement(
				"SELECT product_id, product_name, price, quantity_remaining FROM productlist WHERE product_id =?;");
		ps.setInt(1, product_id);
		rs = ps.executeQuery();

		while (rs.next()) {
			productId = rs.getInt(1);
			product_name = rs.getString(2);
			price = rs.getInt(3);
			remQuantity = rs.getInt(4);
		}

		con = c.callToShopnow();
		ps = con.prepareStatement(
				"INSERT INTO cart_table (username,product_id,product_name,price,selected_quantity) VALUES (?,?,?,?,?)");
		String username = UserRegistration.username;
		ps.setString(1, username);
		ps.setInt(2, productId);
		ps.setString(3, product_name);
		ps.setInt(4, price);
		ps.setInt(5, selected_quantity);
		int i = ps.executeUpdate();
		System.out.println("Done");
		ProductTable pt = new ProductTable();
		pt.insertHistory();
	}

	
	public void updatequatity() throws ClassNotFoundException, SQLException {
		
		shopNowCon = c.callToShopnow();
		ps = shopNowCon.prepareStatement("SELECT quantity_remaining FROM productlist WHERE product_id = ?");
		ps.setInt(1, product_id);
		ps.execute();
		
		rs = ps.executeQuery();
		while(rs.next()) {
		 rquantity= rs.getInt(1);
		}
		
		rquantity = rquantity- selected_quantity;
		
		ps = shopNowCon.prepareStatement("UPDATE productlist SET quantity_remaining = ? WHERE  product_id = ?");
		ps.setInt(1, rquantity);
		
		ps.setInt(2, product_id);
		ps.execute();
	}
	
	
	public void bill() throws ClassNotFoundException, SQLException {
		
		con = c.callToShopnow();
		ps = con.prepareStatement("SELECT product_id, product_name, selected_quantity, price FROM cart_table;");
		rs = ps.executeQuery();
		
		while(rs.next()) {
			cartProductId = rs.getInt(1);
			productName = rs.getString(2);
			cartSelectedQuantity = rs.getInt(3);
			cartPrice = rs.getInt(4);
			multiply= cartSelectedQuantity*cartPrice;
			System.out.println("               | "+cartProductId+"    |   "+productName+"            |  "+cartSelectedQuantity+"|"+cartPrice+"|"+multiply+"|");
		}
		
		
		System.out.println("Your bill is : ");
		System.out.println("                _________________________________________________________________________________________________ ");
		System.out.println("               |                                            Shop Now                                             |");
		System.out.println("               |_________________________________________________________________________________________________|");
		System.out.println("               |       Product Id     |         Product Name         |      Quantity  | Price/Qty  |  Total Price|");
//	    System.out.println("               |______________________|______________________________|________________|____________|_____________|");
//	    System.out.println("               | "+cartProductId+"    |   "+productName+"            |  "+cartSelectedQuantity+"|"+cartPrice+"|"+multiply+"|");
	    System.out.println("               |_________________________________________________________________________________________________|");
//	    System.out.println("               |  Total									"+(total+coupon));
//	    
//	    getTotalAmount();
//	    
//	    System.out.println("               |  Customer Instructions: 		"+instruction);
//	    System.out.println("               |_________________________________________________________________________________________________|");
	    System.out.println("               |                                       FSSAI - 21518181000281                             ");
	    System.out.println("               |_________________________________________________________________________________________________|");
	    System.out.println("               |                                      Thank You! Now order online from our                          ");
	    System.out.println("               |                                         website www.rollsmania.com                                    ");
	    System.out.println("               |_________________________________________________________________________________________________|");
		
	    
	    //pt.insertHistory();
	}
}
