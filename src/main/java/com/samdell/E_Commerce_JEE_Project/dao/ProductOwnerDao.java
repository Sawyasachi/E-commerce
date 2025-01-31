package com.samdell.E_Commerce_JEE_Project.dao;

import com.samdell.E_Commerce_JEE_Project.entity.ProductOwner;

public interface ProductOwnerDao {
	
	public ProductOwner registerProductOwnerDetailDao(ProductOwner productOwner);
	
	public ProductOwner getProductOwnerByEmailDao(String email);
	
	public ProductOwner getProductOwnerDetailByProductOwnerId(int id);

}
