package com.cognizant.CartService.model;

public class Item {
private Integer id;
private String name;
private Double price;
private Double itemTotal;
private String user;
public Item() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getItemTotal() {
	return itemTotal;
}
public void setItemTotal(Double itemTotal) {
	this.itemTotal = itemTotal;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}



}
