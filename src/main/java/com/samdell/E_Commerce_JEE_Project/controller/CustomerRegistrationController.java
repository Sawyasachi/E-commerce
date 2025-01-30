package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;
import java.io.InputStream;

import com.samdell.E_Commerce_JEE_Project.dao.CustomerDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.CustomerDaoImpl;
import com.samdell.E_Commerce_JEE_Project.entity.Customer;

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
	CustomerDao dao = new CustomerDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("customerName");
		String email = req.getParameter("customerEmail");
		String password = req.getParameter("customerPassword");
		Part image = req.getPart("customerImage");
		
		InputStream stream = image.getInputStream();
		
		byte[] image1 = stream.readAllBytes();
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(image1);
		
		Customer customer = new Customer(name,email,password,image1);
		
		Customer customer1 = dao.saveCustomerDetailDao(customer);
		
		if(customer1 != null) {
			System.out.println("Data saved successfully....");
			req.getRequestDispatcher("customerLogin.jsp").forward(req, resp);
		} else {
			System.out.println("Something went wrong..");
			req.setAttribute("msg", "Check your detail..");
			req.getRequestDispatcher("customerRegister.jsp").forward(req, resp);
		}
	}
}
