package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;

import com.samdell.E_Commerce_JEE_Project.dao.ProductDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.ProductDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/deleteProduct")
public class DeleteProductController extends HttpServlet{
	ProductDao dao = new ProductDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		
		boolean result = dao.deleteProductDetailDao(productId);
		
		if(result) {
			req.setAttribute("msg", "Product deleted Successfully....");
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Something went wrong...");
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		}
		
	}
}
