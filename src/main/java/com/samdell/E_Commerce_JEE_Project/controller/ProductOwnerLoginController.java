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
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginProductOwner")
public class ProductOwnerLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String email = req.getParameter("productOwnerEmail");
		String password = req.getParameter("productOwnerPassword");
		
		ProductOwnerDao dao = new ProductOwnerDaoImpl();
		
		ProductOwner productOwner = dao.getProductOwnerByEmailDao(email);
		
		if(productOwner != null) {
			
			if(productOwner.getProductOwnerVerify().equalsIgnoreCase("yes")) {
				
				if(productOwner.getProductOwnerPassword().equals(password)) {
					session.setAttribute("session", email);
					req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
				} else {
					req.setAttribute("msg", "password is wrong....");
					req.getRequestDispatcher("product-owner-login.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("msg", "Product Owner is not verified...");
				req.getRequestDispatcher("product-owner-login.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "email is wrong....");
			req.getRequestDispatcher("product-owner-login.jsp").forward(req, resp);
		}
	}
}
