package com.samdell.E_Commerce_JEE_Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	
}
