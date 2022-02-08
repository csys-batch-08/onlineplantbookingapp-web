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

import com.onlineplantbooking.daoImpl.OrdersDaoImpl;
import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.User;

@WebServlet("/ShowCancelOrderServlet")
public class ShowCancelOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		OrdersDaoImpl orderDao = new OrdersDaoImpl();
		List<Orders> orderList = orderDao.ShowOrders(user);
		session.setAttribute("order", orderList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("orderCancel.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		doGet(request, response);
	}

}
