package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlineplantbooking.model.Orders;
import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.model.User;
import com.onlineplantbooking.util.ConnectionUtil;

public class OrdersDaoImpl {
	
	static final String USERID = "USER_ID";
	static final String USERNAME = "USER_NAME";
	static final String EMAILD = "EMAIL_ID";
	static final String USERPASSWORD = "USER_PASSWORD";
	static final String MOBILENUMBER = "MOBILE_NUMBER";
	static final String ADDRESS = "ADDRESS";
	static final String ROLENAME = "ROLE_NAME";
	static final String WALLET = "WALLET";
	static final String ORDERSID = "ORDERS_ID";
	static final String PLANTID= "PLANT_ID";
	static final String QUANTITY  = "QUANTITY";
	static final String TOTALPRICE="TOTALPRICE";
	static final String ORDERATE="ORDER_DATE";
	static final String ORDERSTATUS="ORDER_STATUS";
	
	

//insert order	
	public User insertOrder(Orders order) throws SQLException {
		ProductDaoImpl proDao = new ProductDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int userId = userDaoImpl.findUserId(order.getUser());
		Statement statement = null;
		List<Product> plant_List = proDao.findProductId(order.getProduct());
		int plant_id=0;
		for(int i=0;i<plant_List.size();i++) {
			plant_id=plant_List.get(i).getPlantId();
		}

		Connection connection = ConnectionUtil.getDbConnection();
		String query2 = "select user_id,user_name,email_id,user_password,mobile_number,address,role_name,wallet from user_details where user_id='" + userId + "'";
		statement = connection.createStatement();
		ResultSet rs1 = statement.executeQuery(query2);
		double wallet = 0;
		

		User user=null;
		if (rs1.next()) {
			wallet = rs1.getDouble(8);
			 user=new User(rs1.getInt(USERID),rs1.getString(USERNAME),rs1.getString(EMAILD),rs1.getString(USERPASSWORD),rs1.getLong(MOBILENUMBER),rs1.getString(ADDRESS),rs1.getString(ROLENAME),rs1.getDouble(WALLET));
			
		}

		if (wallet > order.getTotalPrice()) {

			String query = "update user_details set wallet=wallet-'" + order.getTotalPrice() + "' where user_id='"
					+ userId + "'";
			 statement = connection.createStatement();
			statement.executeUpdate(query);
			String insertQuery = "insert into order_details(user_id,plant_id,quantity,totalprice,address,order_date) values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = null;

			try {
				preparedStatement = connection.prepareStatement(insertQuery);
				preparedStatement.setInt(1, userId);
				preparedStatement.setInt(2, plant_id);
				preparedStatement.setInt(3, order.getQuantity());
				preparedStatement.setDouble(4, order.getTotalPrice());
				preparedStatement.setString(5, order.getAddress());
				preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
			    preparedStatement.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				ConnectionUtil.closePreparedStatement(preparedStatement, connection, rs1);
			}
		} 
		
		return user;
	}

//admin  update product

	public void update(int quantity, int order_id) throws SQLException {
		String updateQuery = "update plant_orders set quantity =? where order_id= ?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement pstPreparedStatement = connection.prepareStatement(updateQuery);
		pstPreparedStatement.setInt(1, quantity);
		pstPreparedStatement.setInt(2, order_id);
		pstPreparedStatement.close();
		connection.close();

	}

//delete product
	
	public void delete(int orderId) throws SQLException {
		String deleteQuery = "delete from plant_orders where order_id=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement pstmPreparedStatement = connection.prepareStatement(deleteQuery);
		pstmPreparedStatement.setInt(1, orderId);
	    pstmPreparedStatement.executeUpdate();
		pstmPreparedStatement.close();
		connection.close();

	}
// user show order
	public List<Orders> ShowOrder(User user) {
		List<Orders> orderList = new ArrayList<Orders>();
		String query = "select user_id,plant_id,quantity,totalprice,address,order_date,order_status  from order_details  where order_status='not delivered' and  user_id=? order by order_date desc";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet =null;
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			 resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductDaoImpl productDao = new ProductDaoImpl();
				Product product = productDao.findProduct(resultSet.getInt(PLANTID));
				Date dates=resultSet.getTimestamp(ORDERATE);
				
				Orders order = new Orders(product,user, resultSet.getInt(QUANTITY), resultSet.getInt(TOTALPRICE), resultSet.getString(ADDRESS),dates);
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return orderList;

	}

	
	public boolean cancelOrder(int orderid)
	
	{  
		Connection connection = ConnectionUtil.getDbConnection();
	    String query="update order_details set ORDER_STATUS='cancel' where orders_id=?";
	    boolean flag=false;
	    PreparedStatement psPreparedStatement =null;
	    try {
			psPreparedStatement = connection.prepareStatement(query);
			psPreparedStatement.setInt(1, orderid);
			flag=psPreparedStatement.executeUpdate()>0;
			} catch (SQLException e) {
		
			e.printStackTrace();
		}
	    finally {
	    	ConnectionUtil.closePreparedStatement(psPreparedStatement, connection);
	    }
		return flag;
		
	}
	public String orderStatus(int orderid)
	{   Connection connection = ConnectionUtil.getDbConnection();
	    String query="select order_status from order_details  where orders_id=?";
	    PreparedStatement psPreparedStatement =null;
	    String status=null;
	    try {
			psPreparedStatement = connection.prepareStatement(query);
		
			psPreparedStatement.setInt(1, orderid);
			ResultSet rs=psPreparedStatement.executeQuery();
			if(rs.next()) {
				status=rs.getString(1);
			}
			
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    finally {
	    	ConnectionUtil.closePreparedStatement(psPreparedStatement, connection);
	    }
		return status;
		
	}
	
	public List<Orders> ShowOrders(User user) {
		List<Orders> orderList = new ArrayList<Orders>();
		String query = "select  ORDERS_ID,PLANT_ID,USER_ID,QUANTITY,TOTALPRICE,ADDRESS,ORDER_DATE from order_details  where user_id=" + user.getUserId()+"order by order_date desc";
		Connection connection = ConnectionUtil.getDbConnection();
		Statement statement =null;
		ResultSet resultSet =null;
		try {
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				ProductDaoImpl productDao = new ProductDaoImpl();
				Product product = productDao.findProduct(resultSet.getInt(PLANTID));
				Date dates=resultSet.getTimestamp(ORDERATE);
				
				Orders order = new Orders(resultSet.getInt(ORDERSID),product, user, resultSet.getInt(QUANTITY), resultSet.getInt(TOTALPRICE), resultSet.getString(ADDRESS),dates);
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}

		return orderList;

	}
	//show cancel orders	
	
	public List<Orders> showCancelOrder(User user) {
		Connection connection = ConnectionUtil.getDbConnection();
		List<Orders> orderList = new ArrayList<Orders>();
		String Query="select   ORDERS_ID,PLANT_ID,USER_ID,QUANTITY,TOTALPRICE,ADDRESS,ORDER_DATE,ORDER_STATUS from order_details where order_status='cancel' and user_id='"+user.getUserId()+"'order by order_date desc";
		ResultSet resultSet =null;
		Statement statement = null;
		try {
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(Query);
			while(resultSet.next()) {
			 
			ProductDaoImpl productDao = new ProductDaoImpl();
			Product pro = productDao.findProduct(resultSet.getInt(PLANTID));
			Date dates=resultSet.getTimestamp(ORDERATE);
			Orders order=new Orders(resultSet.getInt(ORDERSID),pro,user,resultSet.getInt(QUANTITY),resultSet.getInt(TOTALPRICE),resultSet.getString(ADDRESS),dates,resultSet.getString(ORDERSTATUS));
			orderList.add(order);
			
		}
			return orderList;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		
		return orderList;
		
	}

}
