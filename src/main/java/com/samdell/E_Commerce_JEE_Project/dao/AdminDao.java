package com.samdell.E_Commerce_JEE_Project.dao;

import com.samdell.E_Commerce_JEE_Project.entity.Admin;

public interface AdminDao {
	
	public Admin getAdminByEmailDao(String email);

}
