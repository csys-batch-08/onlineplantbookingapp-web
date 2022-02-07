package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;

@WebServlet("/ShowUserServlet")

public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.showAllUser();
		HttpSession session = request.getSession();
		session.setAttribute("user", userList);
		System.out.println(userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showUser.jsp");
		dispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
