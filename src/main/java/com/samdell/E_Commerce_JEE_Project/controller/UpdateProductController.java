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
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/updateProduct")
@MultipartConfig
public class UpdateProductController extends HttpServlet {
	ProductDao dao = new ProductDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));

		String name = req.getParameter("productName");
		String color = req.getParameter("productColor");
		int quantity = Integer.parseInt(req.getParameter("productQuantity"));
		double price = Double.parseDouble(req.getParameter("productPrice"));

		String brand = req.getParameter("productBrand");
		Part part = req.getPart("productImage");

		InputStream stream = part.getInputStream();
		byte[] image = stream.readAllBytes();
		
		Product product = new Product();
		
		product.setProductId(productId);
		product.setProductName(name);
		product.setProductColor(color);
		product.setProductQuant(quantity);
		product.setProductPrice(price);
		product.setProductBrand(brand);
		product.setProductImage(image);
		
		Product updateProduct = dao.updateProductDao(product);
		
		if(updateProduct != null) {
			req.setAttribute("msg", "updated product detail..."+product.getProductId());
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Something went worng to update Product"+product.getProductId());
			req.getRequestDispatcher("Product-owner-home.jsp").forward(req, resp);
		}
	}
}
