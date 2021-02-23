package com.cognizant.ProductCatalogService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {

 @Id
 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name;
private Double price;
private String description;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(Integer id,String name, Double price, String description) {
	super();
	this.name = name;
	this.price = price;
	this.description = description;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
}


}
