package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.UserDaoImpl;
import com.onlineplantbooking.model.User;
@WebServlet("/rechargeWallet")

public class RechargeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     Double wallet=Double.parseDouble(request.getParameter("amount"));
     HttpSession session=request.getSession();
     User user=(User)session.getAttribute("currentUser");
     String email=user.getEmailId();	
     UserDaoImpl userDao=new UserDaoImpl();
         
      user=new User(wallet,email);
    
     userDao.updatewall(user);
     response.sendRedirect("myProfile.jsp");
    					
	}

}
