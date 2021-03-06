package com.onlineplantbooking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;

@WebServlet("/Register")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("username");
			String emailId = request.getParameter("email");
			String password = request.getParameter("password");
			Long mobileNumber = Long.parseLong(request.getParameter("mobilenumber"));
			String address = request.getParameter("address");
			User user = new User(name, emailId, password, mobileNumber, address);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			userDaoImpl.insertUser(user);

			response.sendRedirect("login.jsp");
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
