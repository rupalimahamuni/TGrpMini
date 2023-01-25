package com.grpt.miniproject;

public class AdminLogin {
	
private final String adminId = "1234" ;
private final String adminPass = "1234" ;


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
}
