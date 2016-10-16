package com.clothing.sarees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class product {

	
private int productId;
private String name;
private String description;
private int price;

@Id
@Column(name = "productid")
public int getproductId() {
	return productId;
}
public void setproductId(int productId) {
	this.productId = productId;
}

@Column(name = "name")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Column(name = "description")
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

@Column(name = "price")
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

	
}
