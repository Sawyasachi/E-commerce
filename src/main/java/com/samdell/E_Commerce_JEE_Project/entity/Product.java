package com.samdell.E_Commerce_JEE_Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private int productId;
	private String productName;
	private String productColor;
	private double productPrice;
	private int productQuant;
	private String productBrand;
	private byte[] productImage;
	
	// foreign key productOwner
	private int productOwnerId;

	public Product(String productName, String productColor, double productPrice, int productQuant,
			String productBrand, byte[] productImage, int productOwnerId) {
		super();
		this.productName = productName;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.productQuant = productQuant;
		this.productBrand = productBrand;
		this.productImage = productImage;
		this.productOwnerId = productOwnerId;
	}
	
	

}
