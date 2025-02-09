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
@WebServlet("/updateProductOwner")
public class UpdateProductOwnerDetailController extends HttpServlet{
	
	ProductOwnerDao dao = new ProductOwnerDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		ProductOwner productOwner = new ProductOwner(id,name,email);
		
		boolean result = dao.updateProductOwnerDetail(productOwner);
		
		if(result) {
			req.setAttribute("msg", "Product Owner updated "+productOwner.getProductOwnerId());
			req.getRequestDispatcher("product-owner-login.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Something went wrong with Product Owner"+productOwner.getProductOwnerId());
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		}
	}

}
