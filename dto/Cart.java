package com.mo.dto;

public class Cart {
	private int price;
	private int quantity;
	public Store productId;
	public Customer customerId;
	public Order transactionId;
	public Cart() {}
	public Cart(int price, int quantity, Store productId, Customer customerId, Order transactionId) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.productId = productId;
		this.customerId = customerId;
		this.transactionId = transactionId;
	}
	
	@Override
	public String toString() {
		return "Cart [price=" + price + ", quantity=" + quantity + ", productId=" + productId + ", customerId="
				+ customerId + ", transactionId=" + transactionId + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Store getProductId() {
		return productId;
	}
	public void setProductId(Store productId) {
		this.productId = productId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Order getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Order transactionId) {
		this.transactionId = transactionId;
	}
	


}
