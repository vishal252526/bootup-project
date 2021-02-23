package com.cognizant.OrderService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Cart {
 private String user;
private Integer product;
private Integer quantity;
private Double amount;
public Cart() {
	super();
}

public Integer getProduct() {
	return product;
}
public void setProduct(Integer product) {
	this.product = product;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

}