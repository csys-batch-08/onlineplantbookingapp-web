package com.onlineplantbooking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;

@WebServlet("/deletePro")
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			int productId = Integer.parseInt(request.getParameter("plantId"));
			productDaoImpl.deleteProduct(productId);
			response.sendRedirect("admin.jsp");
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ProductDaoImpl productDao = new ProductDaoImpl();
			int productId = Integer.parseInt(request.getParameter("plantId"));
			productDao.deleteProduct(productId);
			response.sendRedirect("admin.jsp");
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
	}

}
