package com.samdell.E_Commerce_JEE_Project.dao;

import java.util.List;

import com.samdell.E_Commerce_JEE_Project.entity.ProductOwner;

public interface ProductOwnerDao {
	
	public ProductOwner registerProductOwnerDetailDao(ProductOwner productOwner);
	
	public ProductOwner getProductOwnerByEmailDao(String email);
	
//	public ProductOwner getProductOwnerDetailByProductOwnerId(int id);
	
	public List<ProductOwner> getAllNonVerifiedProductOwnerDao();
	public List<ProductOwner> getAllVerifiedProductOwnerDao();
	
	public boolean verifyProductOwnerDao(int id);
	public boolean unVerifiedProductOwnerDao(int id);
	
	public boolean updateProductOwnerDetail(ProductOwner productOwner);

}
