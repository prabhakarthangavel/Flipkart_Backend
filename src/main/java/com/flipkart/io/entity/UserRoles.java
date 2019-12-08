package com.flipkart.io.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
    private int id;
    
    @Column(name = "role")
    private String role;
 
    
    @ManyToOne(	 cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
    private AccountRegEntity userENtity;  

	public AccountRegEntity getUserENtity() {
		return userENtity;
	}

	public void setUserENtity(AccountRegEntity userENtity) {
		this.userENtity = userENtity;
	}

	public String getRole() {
		return role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	} 
}
