package com.douglas.example.crudbk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StoreProduct {
	
	@Id
	@GeneratedValue
	private Long id;
	private String storeProductName;
	private String storeProductDescription;
	
	
	
	public StoreProduct() {
	
	}

	public StoreProduct(Long id,String storeProductName, String storeProductDescription) {
		super();
		this.id=id;
		this.storeProductName = storeProductName;
		this.storeProductDescription = storeProductDescription;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreProductName() {
		return storeProductName;
	}

	public void setStoreProductName(String storeProductName) {
		this.storeProductName = storeProductName;
	}

	public String getStoreProductDescription() {
		return storeProductDescription;
	}

	public void setStoreProductDescription(String storeProductDescription) {
		this.storeProductDescription = storeProductDescription;
	}
	

	
	
}
