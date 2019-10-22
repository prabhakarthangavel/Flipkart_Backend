package com.flipkart.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="products")
public class MensAccsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -556400911708718601L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String image_url;
	@Column
	private float price;
	@Column
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
