package com.grpt.miniproject;

public class AdminLogin {
	
private String adminId ;
private String adminPass ;
public String getAdminId() {
	return adminId;
}
public void setAdminId(String adminId) {
	this.adminId = adminId;
}
public String getAdminPass() {
	return adminPass;
}
public void setAdminPass(String adminPass) {
	this.adminPass = adminPass;
}
public AdminLogin(String adminId, String adminPass) {
	super();
	this.adminId = adminId;
	this.adminPass = adminPass;
}
@Override
public String toString() {
	return "AdminLogin [adminId=" + adminId + ", adminPass=" + adminPass + "]";
}



}
