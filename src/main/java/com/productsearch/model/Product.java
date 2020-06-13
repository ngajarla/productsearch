package com.productsearch.model;

public class Product {

	private int id;
	private String productName;
	private String description;
	private String image;
	private String rating;
	private String category;
	
	
	public Product() {
		
	}
	
	public Product(int id, String productName, String description, String image, String rating, String category) {
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.image = image;
		this.rating = rating;
		this.category = category;
		
	
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
