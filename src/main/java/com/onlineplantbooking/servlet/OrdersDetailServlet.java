package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.OrdersDaoImpl;
import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.model.User;

@WebServlet("/ordersDetailServlet")

public class OrdersDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User rs = (User) session.getAttribute("currentUser");

		Product product = (Product) session.getAttribute("currentPlant1");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int plantPrice = Integer.parseInt(request.getParameter("total"));
		session.setAttribute("total", plantPrice);
		String address = request.getParameter("addresss");

		Orders order = new Orders(product, rs, quantity, plantPrice, address);

		UserDaoImpl userDao = new UserDaoImpl();
		OrdersDaoImpl orderDao = new OrdersDaoImpl();
	

		try {
			User user1 = orderDao.insertOrder(order);
			int userId = user1.getUserId();
			List<User> userList = userDao.myProfile(userId);
			if (user1 != null) {
				HttpSession session1 = request.getSession();

				session1.setAttribute("UpdateList", userList);
				response.sendRedirect("ShowOrderServlet");

			} else  
				response.sendRedirect("orderDetails.jsp");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
