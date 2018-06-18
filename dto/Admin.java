package com.mo.dto;

public class Admin {
private String userId;
private String password;
public Admin(String userId, String password) {
	super();
	this.userId = userId;
	this.password = password;
}
@Override
public String toString() {
	return "Admin [userId=" + userId + ", password=" + password + "]";
}


public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
