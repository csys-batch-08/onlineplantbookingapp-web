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


@WebServlet("/showInactive")
public class ShowInactivePlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductDaoImpl productDaoImpl=new ProductDaoImpl();
			List<Product> productList=productDaoImpl.showInactiveProduct();
			
			request.setAttribute("plantinactiveList", productList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("showInactiveProduct.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
