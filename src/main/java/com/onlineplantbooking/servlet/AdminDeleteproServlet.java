package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Product;

@WebServlet("/AdminDeleteproServlet")
public class AdminDeleteproServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDaoImpl productDao = new ProductDaoImpl();
		List<Product> productList = productDao.showProduct();
		request.setAttribute("product", productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deleteProduct.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
