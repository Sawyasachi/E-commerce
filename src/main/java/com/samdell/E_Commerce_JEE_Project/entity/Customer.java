package com.samdell.E_Commerce_JEE_Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private byte[] customerImage;
	
	public Customer(String customerName, String customerEmail, String customerPassword, byte[] customerImage) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerImage = customerImage;
	}
	
	

}
