package com.ts.dto;

public class User {
private String id;
private String name;
private String department;
private String email;
private String role;
private String password;
private int noOfArts;
private int year;
public Admin adminId;

public User(){
}
public User(String id,String name, String department, String email,String role, String password,int noOfArts,int year, Admin adminId) {
	this.id = id;
	this.name = name;
	this.department = department;
	this.email = email;
	this.role = role;
	this.password = password;
	this.noOfArts= noOfArts;
	this.year = year;
	this.adminId=adminId;
}

@Override
public String toString() {
	return "UserDTO [id=" + id + ", name=" + name + ",department=" + department + ",email=" + email + ", role=" + role + ", password=" + password + ", noOfArts=" + noOfArts + ", year=" + year +",adminId=" +adminId + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Admin getAdminId() {
	return adminId;
}
public void setAdminId(Admin adminId) {
	this.adminId = adminId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getNoOfArts() {
	return noOfArts;
}
public void setNoOfArts(int noOfArts) {
	this.noOfArts = noOfArts;
}
}
