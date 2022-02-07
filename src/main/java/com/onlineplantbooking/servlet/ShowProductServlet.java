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

@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ProductDaoImpl productDao = new ProductDaoImpl();
		List<Product> productList = productDao.showProduct();

		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i);
			session.setAttribute("plantName", product.getPlantName());
			session.setAttribute("plantPrice", product.getPlantPrice());
			session.setAttribute("plantId", product.getPlantId());

		}
		request.setAttribute("ShowProduct", productList);
		RequestDispatcher req = request.getRequestDispatcher("buyProduct.jsp");
		req.forward(request, response);
	}
}
