package com.onlineplantbooking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.OrdersDaoImpl;
import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.exception.OrderCancelException;
import com.onlineplantbooking.model.User;

@WebServlet("/ordercancelserv")
public class OrderCancelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			int price = Integer.parseInt(request.getParameter("price"));
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currentUser");
			OrdersDaoImpl orderdao = new OrdersDaoImpl();
			String status = orderdao.orderStatus(orderid);
			try {

				if (status.equals("cancel")) {
					throw new OrderCancelException();

				} else {

					boolean b = orderdao.cancelOrder(orderid);
					if (b == true) {
						UserDaoImpl userdao = new UserDaoImpl();
						boolean b1 = userdao.refundWallet(user, price);
						if (b1 == true) {
							session.setAttribute("cancelsuccess", true);
							response.sendRedirect("orderCancel.jsp");

						}
					}
				}
			} catch (OrderCancelException e) {
				session.setAttribute("cancel", e.getMessage());
				response.sendRedirect("orderCancel.jsp");
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
