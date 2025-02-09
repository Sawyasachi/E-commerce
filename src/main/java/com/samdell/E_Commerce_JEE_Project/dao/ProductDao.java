package com.samdell.E_Commerce_JEE_Project.dao;

import java.util.List;

import com.samdell.E_Commerce_JEE_Project.entity.Product;

public interface ProductDao {
	
	public Product saveProductDetailDao(Product product);
	
	public List<Product> displayAllProductDetailDao();
	
	public List<Product> getProductDetailByProductOwnerIdDao(int productOwnerId);
	
	public boolean deleteProductDetailDao(int proudctId);
	
	public Product updateProductDao(Product product);

}
