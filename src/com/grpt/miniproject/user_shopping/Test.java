package com.grpt.miniproject.user_shopping;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		ShoppingList sl = new ShoppingList();
		try {
			sl.getProductDetails();
//			sl.createCartTable();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
