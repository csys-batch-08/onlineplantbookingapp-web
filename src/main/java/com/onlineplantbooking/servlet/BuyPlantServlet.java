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

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Product;


@WebServlet("/BuyPlantServlet")
public class BuyPlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pName = request.getParameter("plantName");
		String catName = request.getParameter("catName");
		ProductDaoImpl proDao = new ProductDaoImpl();
		Product product = new Product(pName, catName);
		List<Product> priceList = proDao.findProductId(product);
		List<Product> productList1 = new ArrayList<Product>();
		productList1.add(product);
		session.setAttribute("currentPlant", productList1);
		session.setAttribute("currentPlant1", product);
		session.setAttribute("productPrice", priceList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("orderDetails.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		doGet(request, response);
	}

}
