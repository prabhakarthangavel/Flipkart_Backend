package com.flipkart.io.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="user_role")
@Table(name="user_role")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
    private int id;
    
    @Column
    private String role;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id",insertable = false, updatable = false)
    private AccountRegEntity userENtity;
	
	public AccountRegEntity getUserENtity() {
		return userENtity;
	}

	public void setUserENtity(AccountRegEntity userENtity) {
		this.userENtity = userENtity;
	}

//	public int getUser_id() {
//		return id;
//	}
//
//	public void setUser_id(int id) {
//		this.id = id;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	} 
}
