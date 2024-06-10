package com.cosmetic.cosmeticModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CosmeticProductList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String productname;
	private String price;
	
//	private String userid;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private CosmeticUser cosmeticUser;
	
	public CosmeticProductList() {}
	
	public CosmeticProductList(Long id,String username, String productname, String price) {
		
		this.id = id;
		this.username = username;
		this.productname = productname;
		this.price = price;
		
	}

	public Long getId() {
		return id;
	}
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
//	public String getUserid() {
//		return userid;
//	}
//	
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}
	
}
