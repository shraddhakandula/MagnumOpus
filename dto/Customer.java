package com.ts.dto;

public class Customer {
	private String id;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String flat;
	private String street;
	private String colony;
	private String area;
	private String landmark;
	
public Customer() {
	
}
	public Customer(String id, String name, String email, String password, String mobile, String flat,
			String street, String colony, String area, String landmark) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.flat = flat;
		this.street = street;
		this.colony = colony;
		this.area = area;
		this.landmark = landmark;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", flat=" + flat + ", street=" + street + ", colony=" + colony
				+ ", area=" + area + ", landmark=" + landmark + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
