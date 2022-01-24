package com.onlineplantbooking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;

public class UpdateProfileServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("userName");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		Long phoneno=Long.parseLong(request.getParameter("mobileNo"));
		String address=request.getParameter("address");
		User user=new User(name,emailId,password,phoneno,address);
		UserDaoImpl userDao=new UserDaoImpl();
		userDao.update(user);
		
		
	}

}
