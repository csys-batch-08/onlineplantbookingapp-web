package com.onlineplantbooking.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Product;

@WebServlet("/SearchProductServlet")

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String search = request.getParameter("search");
			ProductDaoImpl productDao = new ProductDaoImpl();
			List<Product> listProduct = productDao.filterPlant(search);

			HttpSession session = request.getSession();
			session.setAttribute("list", listProduct);
			response.sendRedirect("search.jsp");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
