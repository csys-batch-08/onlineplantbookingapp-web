package com.onlineplantbooking.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineplantbooking.model.Cart;
import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.util.ConnectionUtil;

public class CartDaoImpl {
    
	//insert cart
	public void insertCart(Cart cart) {
    	String insertQuery="insert into cart(user_id,plant_id)values(?,?)";
    	ConnectionUtil con=new ConnectionUtil();
        Connection c1=con.getDbConnection();
        PreparedStatement p1;
       
        try {
			p1=c1.prepareStatement(insertQuery);
			p1.setInt(1,cart.getUserId());
			p1.setInt(2, cart.getPlantId());
			p1.executeUpdate();
			p1.executeUpdate("commit");
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
        
         
        
    }
	
//fetch cart	
    
public List<Product> fetchCart(int userId){
	List<Product> productList=new ArrayList<>();
	String query="select plant_id,plant_name,plant_description,plant_price,category_name from product_details where plant_id in(select plant_id from cart where user_id in ?)";
	Connection con=ConnectionUtil.getDbConnection();
	try {
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, userId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			
			productList.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return productList ;
	}
    

//show cart	    
    
    public List<Cart> showCart(){
		List<Cart> cartList=new ArrayList<Cart>();
		String cart="select * from cart";
		Connection con=ConnectionUtil.getDbConnection();
		try {
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(cart);
			while(rs.next()) {
				Cart showCart=new Cart(rs.getInt(2),rs.getInt(3));
				cartList.add(showCart);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cartList;
		
	}

	
}
