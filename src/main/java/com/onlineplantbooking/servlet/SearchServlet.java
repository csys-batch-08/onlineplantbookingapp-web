package com.onlineplantbooking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineplantbooking.daoImpl.ProductDaoImpl;
import com.onlineplantbooking.model.Product;
@WebServlet("/SearchProductServlet")
/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String search=request.getParameter("search");
	    ProductDaoImpl productDao=new ProductDaoImpl();
	    List<Product> listProduct=productDao.filterPlant(search);
	    List<Product> list=new ArrayList<Product>();
	   for(int i=0;i<listProduct.size();i++) {
		   Product product=listProduct.get(i);
		   if(product.getCategoryName().equalsIgnoreCase(search)) {
			   list.add(product);
		   }
		   else if(product.getPlantName().equalsIgnoreCase(search)) {
			   list.add(product);
		   }
		   for(int j=0;j<list.size();j++) {
			  Product product1=list.get(j) ;
		   }
		   
	       
	   }
	HttpSession session=request.getSession();
	session.setAttribute("list", list);
	response.sendRedirect("search.jsp");
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
