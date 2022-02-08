package com.onlineplantbooking.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.onlineplantbooking.model.User;
import com.onlineplantbooking.util.ConnectionUtil;

public class UserDaoImpl {
	static final String USERID = "USER_ID";
	static final String USERNAME = "USER_NAME";
	static final String EMAILD = "EMAIL_ID";
	static final String USERPASSWORD = "USER_PASSWORD";
	static final String MOBILENUMBER = "MOBILE_NUMBER";
	static final String ADDRESS = "ADDRESS";
	static final String ROLENAME = "ROLE_NAME";
	static final String WALLET = "WALLET";

	public void insertUser(User user) {
		String insertQuery = "insert into user_details(user_name,email_id,user_password,mobile_number,address) values(?,?,?,?,?)";

		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmailId());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getMobileNumber());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();
			e.printStackTrace();

		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection);
		}

	}

	public User validateUser(String email, String Password) {
		String validateQuery = "select USER_ID,USER_NAME,EMAIL_ID,USER_PASSWORD,MOBILE_NUMBER,ADDRESS,ROLE_NAME,WALLET from user_details "
				+ "where   Email_id= ? and user_password =?";

		Connection connection = ConnectionUtil.getDbConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(validateQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, Password);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt(USERID), resultSet.getString(USERNAME), resultSet.getString(EMAILD),
						resultSet.getString(USERPASSWORD), resultSet.getLong(MOBILENUMBER),
						resultSet.getString(ADDRESS), resultSet.getString(ROLENAME), resultSet.getDouble(WALLET));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return user;
	}

	public void update(String update)  {

		String updateQuery = "update user_details set user_password=? where email_id=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement =null;
		try {
			 preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, update.split(",")[0]);
			preparedStatement.setString(2, update.split(",")[1]);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection);
		}
		
		
		
	}

//show all user method 

	public List<User> showAllUser() {
		List<User> userList = new ArrayList<User>();

		String selectQuery = "select USER_ID,USER_NAME,EMAIL_ID,USER_PASSWORD,MOBILE_NUMBER,ADDRESS  from user_details where role_name='user'";

		Connection connection = ConnectionUtil.getDbConnection();
		Statement Statement = null;
		ResultSet resultSet = null;

		try {
			Statement = connection.createStatement();
			resultSet = Statement.executeQuery(selectQuery);
			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt(USERID), resultSet.getString(USERNAME),
						resultSet.getString(EMAILD), resultSet.getString(USERPASSWORD),
						Long.parseLong(resultSet.getString(MOBILENUMBER)), resultSet.getString(ADDRESS)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(Statement, connection, resultSet);
		}

		return userList;
	}

	public int findUserId(User currentUser) {

		String findUserID = "select user_id from user_details where user_name='" + currentUser.getName() + "'";
		Connection connection = ConnectionUtil.getDbConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		int userId = 0;
		try {
			statement = connection.createStatement();

			resultSet = statement.executeQuery(findUserID);

			if (resultSet.next()) {

				userId = resultSet.getInt(1);
			}
			return userId;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return userId;

	}

	public User findUser(int userId) {

		String findUserID = "select USER_NAME,EMAIL_ID,USER_PASSWORD,MOBILE_NUMBER,ADDRESS from user_details where user_id="
				+ userId;
		Connection connection = ConnectionUtil.getDbConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(findUserID);

			if (resultSet.next()) {

				user = new User(resultSet.getString(USERNAME), resultSet.getString(EMAILD),
						resultSet.getString(USERPASSWORD), resultSet.getLong(MOBILENUMBER),
						resultSet.getString(ADDRESS));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}

		return user;
	}

//wallet
	public int walletbalance(int id)  {
		Connection connection = ConnectionUtil.getDbConnection();
		String query = "select wallet from user_details where user_id=? ";
		PreparedStatement PreparedStatement =null;
		ResultSet resultSet =null;
		try {
			PreparedStatement = connection.prepareStatement(query);
			PreparedStatement.setInt(1, id);
			resultSet = PreparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection, resultSet);
		}
		
		
		return -1;
	}



	public User findUser(String email) {
		String findUserID = "select USER_NAME,EMAIL_ID,USER_PASSWORD,MOBILE_NUMBER,ADDRESS from user_details where emailId='"
				+ email + "'";
		Connection con = ConnectionUtil.getDbConnection();
		User user = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(findUserID);

			if (resultSet.next()) {

				user = new User(resultSet.getString(USERNAME), resultSet.getString(EMAILD),
						resultSet.getString(USERPASSWORD), resultSet.getLong(MOBILENUMBER),
						resultSet.getString(ADDRESS));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(statement, con, resultSet);
		}
		return user;

	}

//wallet update
	public int updatewall(User user) {

		Connection connection = ConnectionUtil.getDbConnection();
		String query = "update user_details set wallet=wallet +  ? where email_id = ?";
		PreparedStatement PreparedStatement = null;
		int i = 0;
		try {

			PreparedStatement = connection.prepareStatement(query);

			PreparedStatement.setDouble(1, user.getWallet());
			PreparedStatement.setString(2, user.getEmailId());
			i = PreparedStatement.executeUpdate();
			PreparedStatement.executeUpdate("commit");

			return i;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection);
		}
		return i;
	}

//update profile
	public void update(User user) {
		String updateQuery = "update user_details set user_name=?,email_id=?,user_password=?,mobile_number=?,address=? where email_id=?";

		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmailId());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getMobileNumber());
			preparedStatement.setString(5, user.getAddress());

			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection);
		}

	}

	public List<User> myProfile(int userId) {
		List<User> userList = new ArrayList<User>();
		String profile = "select  USER_ID,USER_NAME,EMAIL_ID,USER_PASSWORD,MOBILE_NUMBER,ADDRESS,ROLE_NAME,WALLET from user_details where user_id=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement PreparedStatement = null;
		ResultSet resultSet = null;
		try {
			PreparedStatement = connection.prepareStatement(profile);
			PreparedStatement.setInt(1, userId);
			resultSet = PreparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt(USERID), resultSet.getString(USERNAME),
						resultSet.getString(EMAILD), resultSet.getString(USERPASSWORD), resultSet.getLong(MOBILENUMBER),
						resultSet.getString(ADDRESS), resultSet.getString(ROLENAME), resultSet.getDouble(WALLET));
				userList.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(PreparedStatement, connection, resultSet);
		}
		return userList;

	}

	public List<User> myProfileUpdate(int userId) {
		List<User> userList = new ArrayList<User>();
		String profile = "select  USER_ID,USER_NAME,EMAIL_ID,USER_PASSWORD,MOBILE_NUMBER,ADDRESS,ROLE_NAME,WALLET  from user_details where user_id=?";
		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement PreparedStatement = null;
		ResultSet rs = null;
		try {
			PreparedStatement = connection.prepareStatement(profile);
			PreparedStatement.setInt(1, userId);
			rs = PreparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(USERID), rs.getString(USERNAME), rs.getString(EMAILD),
						rs.getString(USERPASSWORD), rs.getLong(MOBILENUMBER), rs.getString(ADDRESS),
						rs.getString(ROLENAME), rs.getDouble(WALLET));
				userList.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			ConnectionUtil.closePreparedStatement(PreparedStatement, connection, rs);
		}

		return userList;

	}

	public boolean refundWallet(User user, int price) {
		Connection connection = ConnectionUtil.getDbConnection();
		UserDaoImpl userdao = new UserDaoImpl();
		int userId = userdao.findUserId(user);
		String updateQuery1 = "update user_details set wallet=" + (user.getWallet() + price) + "where user_id="
				+ user.getUserId();
		Statement statement = null;
		boolean flag = false;
		try {
			statement = connection.createStatement();
			flag = statement.executeUpdate(updateQuery1) > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(statement, connection);
		}
		return flag;

	}

}
