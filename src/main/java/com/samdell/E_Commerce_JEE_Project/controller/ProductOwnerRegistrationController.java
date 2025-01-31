package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;

import com.samdell.E_Commerce_JEE_Project.dao.ProductOwnerDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.ProductOwnerDaoImpl;
import com.samdell.E_Commerce_JEE_Project.entity.ProductOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/productOwnerRegister")
public class ProductOwnerRegistrationController extends HttpServlet{
	ProductOwnerDao dao = new ProductOwnerDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("productOwnerName");
		String email = req.getParameter("productOwnerEmail");
		String password = req.getParameter("productOwnerPassword");
		
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		ProductOwner productOwner = new ProductOwner(name,email,password);
		
		ProductOwner productOwner1 = dao.registerProductOwnerDetailDao(productOwner);
		
		if(productOwner1 != null) {
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Something went wrong...");
			req.getRequestDispatcher("product-owner-register.jsp").forward(req, resp);
		}
	}
}
