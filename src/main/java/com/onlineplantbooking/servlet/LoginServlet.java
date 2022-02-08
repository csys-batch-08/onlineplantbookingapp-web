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

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.User;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String emailId = request.getParameter("loginemail");
		String password = request.getParameter("loginpassword");
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.validateUser(emailId, password);
		String role = user.getRole();

		
		session.setAttribute("userId", user.getUserId());
		
		if (role.equals("user")) {
			session.setAttribute("currentUser", user);
			ProductDaoImpl productDao = new ProductDaoImpl();
			List<Orders> order = productDao.offerPlant();
			request.setAttribute("plantOffer", order);
			RequestDispatcher req = request.getRequestDispatcher("ShowProductServlet");
			req.forward(request, response);

		} else if (role.equals("admin")) {

			response.sendRedirect("admin.jsp?userId=0");

		}
	}
}
