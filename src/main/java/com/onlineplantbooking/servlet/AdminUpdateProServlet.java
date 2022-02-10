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

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Product;

@WebServlet("/AdminUpdateProServlet")
public class AdminUpdateProServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProductDaoImpl productDao = new ProductDaoImpl();
			List<Product> productList = productDao.showProduct();
			request.setAttribute("product", productList);
			RequestDispatcher req = request.getRequestDispatcher("showProduct.jsp");
			req.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
	}

}
