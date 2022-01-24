package com.onlineplantbooking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.CartDaoImpl;
import com.onlineplantbooking.model.Cart;
@WebServlet("/InserCartServlet")
/**
 * Servlet implementation class InserCart
 */
public class InserCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		int plantId=Integer.parseInt(request.getParameter("plantId"));

	String plantName=request.getParameter("plantname");
	
	int userId=(int) session.getAttribute("userId");
	
	Cart cart=new Cart(userId, plantId);
	CartDaoImpl cartDao=new CartDaoImpl();
	cartDao.insertCart(cart);
	response.sendRedirect("userCart.jsp");}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	//String plantName=(String) session.getAttribute("plantName");
	
	int plantId=Integer.parseInt(request.getParameter("plantId"));
	String plantName= request.getParameter("plantname");
	int userId=(int) session.getAttribute("userId");
	Cart cart=new Cart(userId, plantId);
	CartDaoImpl cartDao=new CartDaoImpl();
	cartDao.insertCart(cart);
	response.sendRedirect("userCart.jsp");
	
	}

}
