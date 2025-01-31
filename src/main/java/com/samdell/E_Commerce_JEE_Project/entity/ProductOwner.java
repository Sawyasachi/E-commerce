package com.samdell.E_Commerce_JEE_Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOwner {
	
	private int productOwnerId;
	private String productOwnerName;
	private String productOwnerEmail;
	private String productOwnerPassword;
	private String productOwnerVerify;
	
	public ProductOwner(String productOwnerName, String productOwnerEmail, String productOwnerPassword) {
		super();
		this.productOwnerName = productOwnerName;
		this.productOwnerEmail = productOwnerEmail;
		this.productOwnerPassword = productOwnerPassword;
	}

	public ProductOwner(String productOwnerEmail, String productOwnerPassword) {
		super();
		this.productOwnerEmail = productOwnerEmail;
		this.productOwnerPassword = productOwnerPassword;
	}
	
	
	

}
