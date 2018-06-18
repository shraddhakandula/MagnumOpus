package com.ts.dto;

public class Incharge {
private String id;
private String name;
private String department;
private int year;
private String password;
private String email;
public Admin adminId;
public User userId;
public Incharge(){
}
public Incharge(String id,String name, String department,int year, String password, String email,Admin adminId, User userId) {
	this.setId(id);
	this.name = name;
	this.department = department;
	this.year = year;
	this.password = password;
	this.email = email;
	this.adminId=adminId;
	this.userId=userId;
}

@Override
public String toString() {
	return "Incharge [id=" + id + ", name=" + name + ",department=" + department + ",year=" + year +" password=" + password + ", email=" + email + ", adminId=" +adminId + ",userId=" +userId + "]";
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Admin getAdminId() {
	return adminId;
}
public void setAdminId(Admin admin_adminId) {
	this.adminId = admin_adminId;
}
public User getUserId() {
	return userId;
}
public void setUser_userId(User userId) {
	this.userId = userId;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
