package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;
import java.io.InputStream;

import com.samdell.E_Commerce_JEE_Project.dao.ProductDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.ProductDaoImpl;
import com.samdell.E_Commerce_JEE_Project.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@SuppressWarnings("serial")
@WebServlet(value = "/productRegister")
@MultipartConfig
public class ProductRegisterController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDaoImpl();
		
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		double price = Double.parseDouble(req.getParameter("price"));
		String brand = req.getParameter("brand");
		Part part = req.getPart("image");
		
		InputStream stream = part.getInputStream();
		byte[] image = stream.readAllBytes();
		
		int productOwnerId = Integer.parseInt(req.getParameter("productOwnerId"));
		
		Product product = new Product(name,color,price,quantity,brand,image,productOwnerId);
		
		Product product1 = dao.saveProductDetailDao(product);
		
		if(product1 != null) {
//			session.setAttribute("session", product1);
			req.setAttribute("msg", "Product Added successfully...");
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Something went wrong..");
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		}
	}

}
