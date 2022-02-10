package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	static final String PLANTID = "PLANT_ID";
	static final String QUANTITY = "QUANTITY";
	static final String TOTALPRICE = "TOTALPRICE";
	static final String ORDERATE = "ORDER_DATE";
	static final String ORDERSTATUS = "ORDER_STATUS";

//insert order	
	public User insertOrder(Orders order) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int userId = userDaoImpl.findUserId(order.getUser());
		PreparedStatement preparedStatement = null;

		Connection connection = ConnectionUtil.getDbConnection();
		String query2 = "select user_id,user_name,email_id,user_password,mobile_number,address,role_name,"
				+ "wallet from user_details where user_id=?";
		User user = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			double wallet = 0;
			if (resultSet.next()) {
				wallet = resultSet.getDouble(WALLET);
				user = new User(resultSet.getInt(USERID), resultSet.getString(USERNAME), resultSet.getString(EMAILD),
						resultSet.getString(USERPASSWORD), resultSet.getLong(MOBILENUMBER),
						resultSet.getString(ADDRESS), resultSet.getString(ROLENAME), resultSet.getDouble(WALLET));
			}

			if (wallet > order.getTotalPrice()) {
				updateUserDetail(order.getTotalPrice(), userId);
				OrdersDaoImpl daoImpl=new OrdersDaoImpl();
				daoImpl.order(order);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return user;
	}

	public void updateUserDetail(int price, int user_id) {
		String updateQuery = "update user_details set wallet=wallet-? where user_id=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement pstPreparedStatement = null;
		try {
			pstPreparedStatement = connection.prepareStatement(updateQuery);
			pstPreparedStatement.setInt(1, price);
			pstPreparedStatement.setInt(2, user_id);
			pstPreparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstPreparedStatement, connection);

		}

	}

	public void order(Orders orders) {
		String query = "insert into order_details(user_id,PLANT_ID,quantity,totalprice,address,order_date) values(?,?,?,?,?,?) ";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		ProductDaoImpl daoImpl=new ProductDaoImpl();
		List<Product> plant_List =daoImpl.findProductId(orders.getProduct());
		int plant_id=0;
		for (int i = 0; i < plant_List.size(); i++) {
			plant_id = plant_List.get(i).getPlantId();
		}
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, orders.getUser().getUserId());
			preparedStatement.setInt(2,plant_id );
			preparedStatement.setInt(3, orders.getQuantity());
			preparedStatement.setDouble(4, orders.getTotalPrice());
			preparedStatement.setString(5, orders.getAddress());
			preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
   finally{
	   ConnectionUtil.closePreparedStatement(preparedStatement, connection);
   }
	}

//admin  update product

	public void update(int quantity, int order_id) {
		String updateQuery = "update plant_orders set quantity =? where order_id= ?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement pstPreparedStatement = null;
		try {
			pstPreparedStatement = connection.prepareStatement(updateQuery);
			pstPreparedStatement.setInt(1, quantity);
			pstPreparedStatement.setInt(2, order_id);
			pstPreparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstPreparedStatement, connection);

		}

	}

//delete product
	public void delete(int orderId) {
		String deleteQuery = "delete from plant_orders where order_id=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement pstmPreparedStatement = null;
		try {
			pstmPreparedStatement = connection.prepareStatement(deleteQuery);
			pstmPreparedStatement.setInt(1, orderId);
			pstmPreparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(pstmPreparedStatement, connection);

		}

	}

// user show order
	public List<Orders> ShowOrder(User user) {
		List<Orders> orderList = new ArrayList();
		String query = "select user_id,plant_id,quantity,totalprice,address,order_date,order_status  from order_details  where"
				+ " order_status='not delivered' and  user_id=? order by order_date desc";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductDaoImpl produDaoImpl = new ProductDaoImpl();
				Product product = produDaoImpl.findProduct(resultSet.getInt(PLANTID));
				Date dates = resultSet.getTimestamp(ORDERATE);
				Orders order = new Orders(product, user, resultSet.getInt(QUANTITY), resultSet.getInt(TOTALPRICE),
						resultSet.getString(ADDRESS), dates);
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return orderList;
	}

	public boolean cancelOrder(int orderid)
	{
		Connection connection = ConnectionUtil.getDbConnection();
		String query = "update order_details set ORDER_STATUS='cancel' where orders_id=?";
		boolean flag = false;
		PreparedStatement PreparedStatement = null;
		try {
			PreparedStatement = connection.prepareStatement(query);
			PreparedStatement.setInt(1, orderid);
			flag = PreparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection);
		}
		return flag;
}

	public String orderStatus(int orderid) {
		Connection connection = ConnectionUtil.getDbConnection();
		String query = "select order_status from order_details  where orders_id=?";
		PreparedStatement PreparedStatement = null;
		String status = null;
		try {
			PreparedStatement = connection.prepareStatement(query);

			PreparedStatement.setInt(1, orderid);
			ResultSet rs = PreparedStatement.executeQuery();
			if (rs.next()) {
				status = rs.getString(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection);
		}
		return status;

	}

	public List<Orders> ShowOrders(User user) {
		List<Orders> orderList = new ArrayList();
		String query = "select  ORDERS_ID,PLANT_ID,USER_ID,QUANTITY,TOTALPRICE,ADDRESS,ORDER_DATE "
				+ "from order_details  where user_id= ? order by order_date desc";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductDaoImpl producDaoImpl = new ProductDaoImpl();
				Product product = producDaoImpl.findProduct(resultSet.getInt(PLANTID));
				Date dates = resultSet.getTimestamp(ORDERATE);
				Orders order = new Orders(resultSet.getInt(ORDERSID), product, user, resultSet.getInt(QUANTITY),
						resultSet.getInt(TOTALPRICE), resultSet.getString(ADDRESS), dates);
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return orderList;
	}
	// show cancel orders

	public List<Orders> showCancelOrder(User user) {
		Connection connection = ConnectionUtil.getDbConnection();
		List<Orders> orderList = new ArrayList();
		String Query = "select   ORDERS_ID,PLANT_ID,USER_ID,QUANTITY,TOTALPRICE,ADDRESS,ORDER_DATE,ORDER_STATUS from order_details "
				+ "where order_status='cancel' and user_id=? order by order_date desc";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, user.getUserId());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				ProductDaoImpl producDaoImpl = new ProductDaoImpl();
				Product pro = producDaoImpl.findProduct(resultSet.getInt(PLANTID));
				Date dates = resultSet.getTimestamp(ORDERATE);
				Orders order = new Orders(resultSet.getInt(ORDERSID), pro, user, resultSet.getInt(QUANTITY),
						resultSet.getInt(TOTALPRICE), resultSet.getString(ADDRESS), dates,
						resultSet.getString(ORDERSTATUS));
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

}
