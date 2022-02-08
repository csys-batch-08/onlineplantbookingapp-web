package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;

@WebServlet("/ShowUserServlet")

public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowUserServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.showAllUser();
		
		request.setAttribute("user", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showUser.jsp");
		dispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
