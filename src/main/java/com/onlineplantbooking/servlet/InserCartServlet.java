package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.CartDaoImpl;
import com.onlineplantbooking.model.Cart;
import com.onlineplantbooking.model.Product;

@WebServlet("/InserCartServlet")

public class InserCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			int plantId = Integer.parseInt(request.getParameter("plantId"));
			int userId = (int) session.getAttribute("userId");
			CartDaoImpl cartDao = new CartDaoImpl();
			List<Product> productList = cartDao.fetchCart(userId);
			session.setAttribute("plantList", productList);
			Cart cart = new Cart(userId, plantId);
			cartDao.insertCart(cart);
			response.sendRedirect("userCart.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int plantId = Integer.parseInt(request.getParameter("plantId"));
			int userId = (int) session.getAttribute("userId");
			Cart cart = new Cart(userId, plantId);
			CartDaoImpl cartDao = new CartDaoImpl();
			cartDao.insertCart(cart);
			response.sendRedirect("userCart.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
