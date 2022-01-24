package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;
@WebServlet("/Register")
/**
 * Servlet implementation class Register
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name=request.getParameter("username");
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		Long mobileNumber=Long.parseLong(request.getParameter("mobilenumber"));
		String address=request.getParameter("address");
//		
//		PrintWriter pw=response.getWriter();
	    User user=new User(name,emailId,password,mobileNumber,address);
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.insertUser(user);
		//RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		//rd.forward(request, response);
		response.sendRedirect("login.jsp");
		
	}

}
