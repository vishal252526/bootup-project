package com.cognizant.Ribbonorderservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class OrderHistory {
@Id
 Integer id;
 Date date;
 Double amount;
 String user;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
 
 
}
