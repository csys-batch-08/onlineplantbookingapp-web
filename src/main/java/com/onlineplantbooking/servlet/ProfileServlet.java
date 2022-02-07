package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl userDao=new UserDaoImpl();
		HttpSession session=request.getSession();
		int userId=(int)session.getAttribute("userId");
		List<User> userList=new ArrayList<User>();
		userList=userDao.myProfile(userId);
		session.setAttribute("user",userList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("myProfile.jsp");
		dispatcher.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
}
