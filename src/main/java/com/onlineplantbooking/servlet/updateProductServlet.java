package com.onlineplantbooking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;

@WebServlet("/updateProduct")
public class updateProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ProductDaoImpl productDao = new ProductDaoImpl();

			int plantId = Integer.parseInt(request.getParameter("plantId"));
			int plantPrice = Integer.parseInt(request.getParameter("plantPrice"));

			productDao.updateProduct(plantId, plantPrice);

			response.sendRedirect("admin.jsp");
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
