package com.mo.dto;

public class Art {
private int id;
private String name;
private String rollNo;
private String quote;
private int likes;
private String store;
private String typeOfArt;
public User userId;
public Incharge inchargeId;

public Art() {}
public Art(int id, String name, String rollNo, String quote, int likes, String store, String typeOfArt, User userId,
		Incharge inchargeId) {
	super();
	this.id = id;
	this.name = name;
	this.rollNo = rollNo;
	this.quote = quote;
	this.likes = likes;
	this.store = store;
	this.typeOfArt = typeOfArt;
	this.userId = userId;
	this.inchargeId = inchargeId;
}

@Override
public String toString() {
	return "Art [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", quote=" + quote + ", likes=" + likes
			+ ", store=" + store + ", typeOfArt=" + typeOfArt + ", userId=" + userId + ", inchargeId=" + inchargeId
			+ "]";
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRollNo() {
	return rollNo;
}
public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}
public String getQuote() {
	return quote;
}
public void setQuote(String quote) {
	this.quote = quote;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public String getStore() {
	return store;
}
public void setStore(String store) {
	this.store = store;
}
public String getTypeOfArt() {
	return typeOfArt;
}
public void setTypeOfArt(String typeOfArt) {
	this.typeOfArt = typeOfArt;
}
public User getUserId() {
	return userId;
}
public void setUserId(User userId) {
	this.userId = userId;
}
public Incharge getInchargeId() {
	return inchargeId;
}
public void setInchargeId(Incharge inchargeId) {
	this.inchargeId = inchargeId;
}

}
