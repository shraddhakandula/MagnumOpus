package com.mo.dto;

public class Store {
private int productId;
private String typeOfArt;
private int price;
private String description;
public Art artId;
public Store(){
}
public Store(int productId,String typeOfArt, int price, String description,Art artId) {
	this.productId = productId;
	this.typeOfArt = typeOfArt;
	this.price = price;
	this.description = description;
	this.artId=artId;
}

@Override
public String toString() {
	return "Store [productId=" + productId + ", typeOfArt=" + typeOfArt + ",price=" + price + ",description" + description +",artId=" +artId + "]";
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getTypeOfArt() {
	return typeOfArt;
}
public void setTypeOfArt(String typeOfArt) {
	this.typeOfArt = typeOfArt;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Art getArtsId() {
	return artId;
}
public void setArts_artId(Art artId) {
	this.artId = artId;
}
}
