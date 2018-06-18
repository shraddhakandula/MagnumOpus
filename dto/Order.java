package com.ts.dto;

import java.sql.Date;

public class Order {
private int transactionId;
private Date paymentDate;
private int quantity;
private int finalAmount;
private String status;
public Order(){
}

public Order(int transactionId, Date paymentDate, int quantity, int finalAmount, String status) {
	super();
	this.transactionId = transactionId;
	this.paymentDate = paymentDate;
	this.quantity = quantity;
	this.finalAmount = finalAmount;
	this.status = status;
}

@Override
public String toString() {
	return "Order [transactionId=" + transactionId + ", paymentDate=" + paymentDate + ", quantity=" + quantity
			+ ", finalAmount=" + finalAmount + ", status=" + status + "]";
}

public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public Date getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(Date paymenDate) {
	this.paymentDate = paymenDate;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getFinalAmount() {
	return finalAmount;
}
public void setFinalAmount(int finalAmount) {
	this.finalAmount = finalAmount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
