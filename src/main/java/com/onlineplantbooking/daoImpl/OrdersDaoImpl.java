package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.model.User;
import com.onlineplantbooking.util.ConnectionUtil;

public class OrdersDaoImpl {

//insert order	
	public User insertOrder(Orders order) throws SQLException {
		ProductDaoImpl proDao = new ProductDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int userId = userDaoImpl.findUserId(order.getUser());
		ResultSet plant_id = proDao.findProductId(order.getProduct());
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		int i = 0;
		String query2 = "select * from user_details where user_id='" + userId + "'";
		Statement st = con.createStatement();
		ResultSet rs1 = st.executeQuery(query2);
		double wallet = 0;
		

		User user=null;
		if (rs1.next()) {
			wallet = rs1.getDouble(8);
			 user=new User(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getLong(5),rs1.getString(6),rs1.getString(7),rs1.getDouble(8));
			
		}

		if (wallet > order.getTotalPrice()) {

			String query = "update user_details set wallet=wallet-'" + order.getTotalPrice() + "' where user_id='"
					+ userId + "'";
			Statement st1 = con.createStatement();
			st1.executeUpdate(query);
			String insertQuery = "insert into order_details(user_id,plant_id,quantity,totalprice,address,order_date) values(?,?,?,?,?,?)";

			PreparedStatement pst = null;

			try {
				pst = con.prepareStatement(insertQuery);
				pst.setInt(1, userId);
				if (plant_id.next()) {
					pst.setInt(2, plant_id.getInt(1));
				}
				pst.setInt(3, order.getQuantity());
				pst.setDouble(4, order.getTotalPrice());
				pst.setString(5, order.getAddress());
				pst.setDate(6, new java.sql.Date(new Date().getTime()));
				i = pst.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		} 
		return user;
	}

//admin  update product

	public void update(int quantity, int order_id) throws SQLException {
		String updateQuery = "update plant_orders set quantity =? where order_id= ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, order_id);
		int i = pstmt.executeUpdate();
		System.out.println(i + "row updated");
		pstmt.close();
		con.close();

	}

//delete product
	
	public void delete(int orderId) throws SQLException {
		String deleteQuery = "delete from plant_orders where order_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt1 = con.prepareStatement(deleteQuery);
		pstmt1.setInt(1, orderId);
		int i = pstmt1.executeUpdate();
		pstmt1.close();
		con.close();

	}
// user show order
	public List<Orders> ShowOrder(User user) {
		ConnectionUtil con = new ConnectionUtil();
		List<Orders> orderList = new ArrayList<Orders>();
		String query = "select * from order_details  where order_status='not delivered' and  user_id=" + user.getUserId()+"order by order_date desc";
		Connection conn = con.getDbConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ProductDaoImpl productDao = new ProductDaoImpl();
				Product product = productDao.findProduct(rs.getInt(3));
				Date dates=rs.getTimestamp(7);
				
				Orders order = new Orders(product, user, rs.getInt(4), rs.getInt(5), rs.getString(6),dates);
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;

	}

	
//user canel order	
	public boolean cancelOrder(int orderid)
	{   ConnectionUtil con = new ConnectionUtil();
	     Connection conn = ConnectionUtil.getDbConnection();
	    String query="update order_details set order_status='cancel' where orders_id=?";
	    boolean flag=false;
	    try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		
			pstmt.setInt(1, orderid);
			flag=pstmt.executeUpdate()>0;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	public String orderStatus(int orderid)
	{   ConnectionUtil con = new ConnectionUtil();
	     Connection conn = ConnectionUtil.getDbConnection();
	    String query="select order_status from order_details  where orders_id=?";
	    boolean flag=false;
	    String status=null;
	    try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		
			pstmt.setInt(1, orderid);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				status=rs.getString(1);
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	public List<Orders> ShowOrders(User user) {
		ConnectionUtil con = new ConnectionUtil();
		List<Orders> orderList = new ArrayList<Orders>();
		String query = "select * from order_details  where user_id=" + user.getUserId()+"order by order_date desc";
		Connection conn = con.getDbConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ProductDaoImpl productDao = new ProductDaoImpl();
				Product product = productDao.findProduct(rs.getInt(3));
				Date dates=rs.getTimestamp(7);
				
				Orders order = new Orders(rs.getInt(1),product, user, rs.getInt(4), rs.getInt(5), rs.getString(6),dates);
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;

	}
	//show cancel orders	
	
	public List<Orders> showCancelOrder(User user) {
		ConnectionUtil con = new ConnectionUtil();
		Connection conn = con.getDbConnection();
		List<Orders> orderList = new ArrayList<Orders>();
		String Query="select * from order_details where order_status='cancel' and user_id='"+user.getUserId()+"'";
		ResultSet rs =null;
		try {
			Statement stmt = conn.createStatement();
			 rs = stmt.executeQuery(Query);
			while(rs.next()) {
			 
			ProductDaoImpl productDao = new ProductDaoImpl();
			Product pro = productDao.findProduct(rs.getInt(3));
			Orders order=new Orders(rs.getInt(1),pro,user,rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7),rs.getString(8));
			orderList.add(order);
			
		}
			return orderList;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}		
		return orderList;
		
	}

}
