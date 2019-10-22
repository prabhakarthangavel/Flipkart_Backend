package com.flipkart.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="clothsize")
public class ClothSizeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2441188115138624410L;
	@Id
	@GeneratedValue
	private int cloth_id;
	
	@Column
	private boolean small;
	
	@Column
	private boolean medium;
	
	@Column
	private boolean large;
	
	@OneToOne
	@JoinColumn(name="cloth_id")
	private ClothEntity clothEntity;
	
	public ClothEntity getClothEntity() {
		return clothEntity;
	}
	public void setClothEntity(ClothEntity clothEntity) {
		this.clothEntity = clothEntity;
	}
	
	public int getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}
	public boolean isSmall() {
		return small;
	}
	public void setSmall(boolean small) {
		this.small = small;
	}
	public boolean isMedium() {
		return medium;
	}
	public void setMedium(boolean medium) {
		this.medium = medium;
	}
	public boolean isLarge() {
		return large;
	}
	public void setLarge(boolean large) {
		this.large = large;
	}
	
}
