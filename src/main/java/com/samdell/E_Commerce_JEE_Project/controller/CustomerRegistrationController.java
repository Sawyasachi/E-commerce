package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/customerRegister")
@MultipartConfig
public class CustomerRegistrationController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("customerName");
		String email = req.getParameter("customerEmail");
		String password = req.getParameter("customerPassword");
		Part image = req.getPart("customerImage");
		
		InputStream stream = image.getInputStream();
		
		byte[] image1 = stream.readAllBytes();
	}
}
