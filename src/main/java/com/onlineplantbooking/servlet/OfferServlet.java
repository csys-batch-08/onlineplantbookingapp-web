package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;

/**
 * Servlet implementation class OfferServlet
 */
@WebServlet("/offerServ")
public class OfferServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ProductDaoImpl productDao=new ProductDaoImpl();
		ResultSet resultSet=productDao.offerPlant();
		HttpSession session=request.getSession();
		session.getAttribute("currentUser");
		session.setAttribute("plantOffer", resultSet);
		response.sendRedirect("Offer.jsp");
	}

}
