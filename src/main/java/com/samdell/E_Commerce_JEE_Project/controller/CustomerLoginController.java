package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;

import com.samdell.E_Commerce_JEE_Project.dao.CustomerDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.CustomerDaoImpl;
import com.samdell.E_Commerce_JEE_Project.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginCustomer")
public class CustomerLoginController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("customerEmail");
		String password = req.getParameter("customerPassword");
		
		CustomerDao dao = new CustomerDaoImpl();
		
		Customer customer = dao.getCustomerDetailByEmail(email);
		if(customer != null) {
			if(customer.getCustomerPassword().equals(password)) {
				session.setAttribute("customerSession", email);
				req.getRequestDispatcher("customer-home.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "Password is wrong..");
				req.getRequestDispatcher("customerLogin.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "Email is worng...");
			req.getRequestDispatcher("customerLogin.jsp").forward(req, resp);
		}
	}
}
