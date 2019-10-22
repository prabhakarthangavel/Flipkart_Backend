package com.flipkart.ui.model.response;

public class ClothResponse {
	private int cloth_id;
	private String name;
	private String image_url;
	private float price;
	private String category;
	private ClothSize clothSize;
	
	
	public ClothSize getClothSize() {
		return clothSize;
	}
	public void setClothSize(ClothSize clothSize) {
		this.clothSize = clothSize;
	}
	public int getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
