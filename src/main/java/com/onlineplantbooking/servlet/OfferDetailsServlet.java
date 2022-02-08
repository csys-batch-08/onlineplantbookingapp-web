package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.model.Product;

@WebServlet("/OfferDetailsServlet")
public class OfferDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OfferDetailsServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String plantName = request.getParameter("plantName");
		String categoryName = request.getParameter("catName");

		double offerPrice = Double.parseDouble(request.getParameter("offerprice"));
		int offerprice = (int) Math.round(offerPrice);
		Product product = new Product();
		product.setPlantName(plantName);
		product.setCategoryName(categoryName);
		product.setPlantPrice(offerprice);

		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		HttpSession session = request.getSession();
		request.setAttribute("productOffer", productList);
		session.setAttribute("currentPlant1", product);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("offerDetails.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
