package com.onlineplantbooking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartInsertServlet")
public class CartInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String plantName = request.getParameter("plantName");
		double price = Double.parseDouble(request.getParameter("plantPrice"));
		int plantId = Integer.parseInt(request.getParameter("plantId"));
		HttpSession session = request.getSession();
		session.setAttribute("plantname", plantName);
		session.setAttribute("plantprice", price);
		session.setAttribute("plantid", plantId);
		RequestDispatcher req = request.getRequestDispatcher("insertCart.jsp");
		req.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		doGet(request, response);
	}

}
