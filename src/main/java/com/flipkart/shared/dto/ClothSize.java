package com.flipkart.shared.dto;

import java.io.Serializable;

public class ClothSize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9217272741408779642L;
	private int cloth_id;
	private boolean small;
	private boolean medium;
	private boolean large;
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
