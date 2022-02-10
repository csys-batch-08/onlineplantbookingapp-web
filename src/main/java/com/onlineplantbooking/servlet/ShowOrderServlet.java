package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.OrdersDaoImpl;
import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.User;


@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OrdersDaoImpl orderDao=new OrdersDaoImpl();
			
			HttpSession session=request.getSession(); 
			
			List<User> userList=(List<User>) session.getAttribute("UpdateList");
			
			List<Orders> orderList=orderDao.ShowOrder(userList.get(0));
			
			session.setAttribute("showOrder",orderList);
			session.setAttribute("User", userList.get(0).getWallet());
			response.sendRedirect("showOrder.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
