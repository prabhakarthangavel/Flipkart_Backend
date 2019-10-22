package com.flipkart.shared.dto;

import java.io.Serializable;

public class ProductsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7297222973915334453L;
	private int id;
	private String name;
	private String image_url;
	private float price;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getimage_url() {
		return image_url;
	}
	public void setimage_url(String image_url) {
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
