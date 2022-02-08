package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.Product;

@WebServlet("/offerServ")
public class OfferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDaoImpl productDao = new ProductDaoImpl();
		List<Orders> order = productDao.offerPlant();
		List<Product> productList = new ArrayList<Product>();
		for (int i = 0; i < order.size(); i++) {
			Orders orders = order.get(i);
			Product product = orders.getProduct();

			productList.add(product);
		}

		HttpSession session = request.getSession();
		session.setAttribute("currentPlant1", productList);
		session.getAttribute("currentUser");
		session.setAttribute("plantOffer", order);
		response.sendRedirect("offer.jsp");
	}

}
