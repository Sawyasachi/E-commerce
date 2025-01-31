package com.samdell.E_Commerce_JEE_Project.controller;

import java.io.IOException;

import com.samdell.E_Commerce_JEE_Project.dao.AdminDao;
import com.samdell.E_Commerce_JEE_Project.dao.impl.AdminDaoImpl;
import com.samdell.E_Commerce_JEE_Project.entity.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginAdmin")
public class AdminLogInController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String email = req.getParameter("adminEmail");
		String password = req.getParameter("adminPassword");
		
		AdminDao dao = new AdminDaoImpl();
		
		Admin admin = dao.getAdminByEmailDao(email);
		
		if(admin != null) {
			
			if(admin.getAdminPassword().equals(password)) {
				session.setAttribute("session", email);
				req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "Password is worng...");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "email is worng...");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
	}

}
