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
	
	// for the sign-up
	public ProductOwner(String productOwnerName, String productOwnerEmail, String productOwnerPassword) {
		super();
		this.productOwnerName = productOwnerName;
		this.productOwnerEmail = productOwnerEmail;
		this.productOwnerPassword = productOwnerPassword;
	}

	// login
	public ProductOwner(String productOwnerEmail, String productOwnerPassword) {
		super();
		this.productOwnerEmail = productOwnerEmail;
		this.productOwnerPassword = productOwnerPassword;
	}

	//fetching details
	public ProductOwner(int productOwnerId, String productOwnerName, String productOwnerEmail,
			String productOwnerVerify) {
		super();
		this.productOwnerId = productOwnerId;
		this.productOwnerName = productOwnerName;
		this.productOwnerEmail = productOwnerEmail;
		this.productOwnerVerify = productOwnerVerify;
	}
	
	
	
	
	
	

}
