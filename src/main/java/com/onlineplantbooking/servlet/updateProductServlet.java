package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;

/**
 * Servlet implementation class updateProductServlet
 */
@WebServlet("/updateProduct")
public class updateProductServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDaoImpl productDao=new ProductDaoImpl();
		
		HttpSession session=request.getSession();
		int plantId= Integer.parseInt(request.getParameter("plantId"));
		System.out.println(plantId);
		int plantPrice=Integer.parseInt(request.getParameter("plantPrice"));
		int i=0;
    
			try {
				 i=productDao.updateProduct(plantId,plantPrice);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(i!=0) {
			response.sendRedirect("showProduct.jsp");		

		}else {
			response.sendRedirect("admin.jsp");
		}
		
		
		
	}

}
