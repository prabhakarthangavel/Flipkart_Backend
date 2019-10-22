package com.flipkart.io.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="clothing")
public class ClothEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678163826836967899L;
	
	@Id
	@GeneratedValue
	private int cloth_id;
	
	@Column
	private String name;
	
	@Column
	private String image_url;
	
	@Column
	private float price;
	
	@Column
	private String category;
	
	@OneToOne(mappedBy="clothEntity",cascade=CascadeType.ALL)
	private ClothSizeEntity clothSize;
	
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
	public ClothSizeEntity getClothSize() {
		return clothSize;
	}
	public void setClothSize(ClothSizeEntity clothSize) {
		this.clothSize = clothSize;
	}
}
