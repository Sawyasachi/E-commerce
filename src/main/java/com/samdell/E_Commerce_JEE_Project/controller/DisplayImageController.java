package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.catalina.connector.Response;

import com.samdell.E_Commerce_JEE_Project.dao.ProductDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.ProductDaoImpl;
import com.samdell.E_Commerce_JEE_Project.entity.Product;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DisplayImageController extends HttpServlet{
	ProductDao dao = new ProductDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Product product = dao.getProductDetailByIdDao(id);
		byte[] image = product.getProductImage();
		
		resp.setContentType("image/jpeg");
        OutputStream os = resp.getOutputStream();
        os.write(image);
        os.flush();
        os.close();
	}

}
