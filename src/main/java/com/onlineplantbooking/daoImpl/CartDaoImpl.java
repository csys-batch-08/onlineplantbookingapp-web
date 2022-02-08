package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineplantbooking.model.Cart;
import com.onlineplantbooking.model.Product;
import com.onlineplantbooking.util.ConnectionUtil;

public class CartDaoImpl {

	static final String PLANTID = "PLANT_ID";
	static final String PLANTNAME = "PLANT_NAME";
	static final String PLANTDESCRIPTION = "PLANT_DESCRIPTION";
	static final String PLANTPRICE = "PLANT_PRICE";
	static final String CATEGORYNAME = "CATEGORY_NAME";
	static final String PICTURE = "PICTURE";
	static final String PLANTSTATUS = "PLANT_STATUS";
	static final String USERID = "USER_ID";
	static final String CARTID = "CART_ID";

	public void insertCart(Cart cart) {
		String insertQuery = "insert into cart(user_id,plant_id)values(?,?)";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, cart.getUserId());
			preparedStatement.setInt(2, cart.getPlantId());
			preparedStatement.executeUpdate();
			preparedStatement.executeUpdate("commit");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection);

		}

	}

//fetch cart	

	public List<Product> fetchCart(int userId)
	{
		
		List<Product> productList = new ArrayList<>();
		String query = "select plant_id,plant_name,plant_description,plant_price,category_name from product_details where plant_id in(select plant_id from cart where user_id in ?)";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				productList.add(new Product(resultSet.getInt(PLANTID), resultSet.getString(PLANTNAME),
						resultSet.getString(PLANTDESCRIPTION), resultSet.getInt(PLANTPRICE),
						resultSet.getString(CATEGORYNAME)));

			}
			System.out.println(productList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return productList;
	}

}
