package com.onlineplantbooking.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Product;

@WebServlet("/insertProduct")

public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertProductServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String plantName = request.getParameter("plantname");
		String plantDescription = request.getParameter("plantdescription");
		int plantPrice = Integer.parseInt(request.getParameter(" plantprice"));
		String category = request.getParameter("category");
		String image = request.getParameter("plantimage");
		Product product = new Product(plantName, plantDescription, plantPrice, category, image);
		ProductDaoImpl productDao = new ProductDaoImpl();
		
			productDao.insertProduct(product);
			response.sendRedirect("admin.jsp");
		
			
		

	}

}
