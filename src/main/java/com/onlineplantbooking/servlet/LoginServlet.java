package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.AdminDaoImpl;
import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;
import com.onlineplantbooking.util.ConnectionUtil;

@WebServlet("/login")
/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		
		String emailId=request.getParameter("loginemail");
		String password=request.getParameter("loginpassword");
		
	    UserDaoImpl userDao=new UserDaoImpl();
		User user=userDao.validateUser(emailId, password);
		String role=user.getRole();
		
		HttpSession session1=request.getSession();
		session.setAttribute("userId", user.getUserId());
		
		
		
		if(role.equals("user")) {
			 session1.setAttribute("currentUser",user);
			 ProductDaoImpl productDao=new ProductDaoImpl();
				ResultSet resultSet=productDao.offerPlant();
				session.setAttribute("plantOffer", resultSet);
             RequestDispatcher req=request.getRequestDispatcher("buyProduct.jsp");
             req.forward(request, response);
             
			
		}
		else if(role.equals("admin")) {
		
			response.sendRedirect("admin.jsp?userId=0");
		

		
		}}}

