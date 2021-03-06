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

import com.onlineplantbooking.daoImpl.CartDaoImpl;
import com.onlineplantbooking.model.Product;

@WebServlet("/ViewUserCartServlet")
public class ViewUserCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ViewUserCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CartDaoImpl cartDao = new CartDaoImpl();
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			List<Product> productList = cartDao.fetchCart(userId);
			session.setAttribute("plantList", productList);
			RequestDispatcher req = request.getRequestDispatcher("userCart.jsp");
			req.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
