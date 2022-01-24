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
	public void insertUser(User user) {
		String insertQuery ="insert into user_details(user_name,email_id,user_password,mobile_number,address) values(?,?,?,?,?)";
	    
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmailId());
			pst.setString(3, user.getPassword());
			pst.setLong(4,user.getMobileNumber());
			pst.setString(5,user.getAddress());
			int rows =pst.executeUpdate();
			if(rows>0) {
				System.out.println("Value inserted Succes");
			}
			
		} catch (SQLException e) {
			
            e.getMessage();
			e.printStackTrace();
			System.out.println("Value not inserted in the table");
		}
		
	}
//register and login are same
	
	public  User validateUser(String email,String Password) {
		String validateQuery = "select * from user_details where   Email_id= ? and user_password =?";
		
		Connection con = ConnectionUtil.getDbConnection();
		ResultSet rs=null;
		 User user=null;
		try {
			PreparedStatement pstmt=con.prepareStatement(validateQuery);
			pstmt.setString(1,email);
			pstmt.setString(2,Password);
			
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6),rs.getString(7),rs.getDouble(8));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
public void update(String update) throws SQLException{ 

	String updateQuery="update user_details set user_password=? where email_id=?";
	Connection con=ConnectionUtil.getDbConnection();
	System.out.println("Connection suceessfully");
	
	
	PreparedStatement pstmt=con.prepareStatement(updateQuery);
	pstmt.setString(1,update.split(",")[0]);
	pstmt.setString(2,update.split(",")[1]);
	int i=pstmt.executeUpdate();
	System.out.println(i+"row updated");
	pstmt.close();
	con.close();
}
public void deleteUser(int userId) throws SQLException  {
	String deleteQuery="delete from user_details where user_id=?";
	Connection con=ConnectionUtil.getDbConnection();
	System.out.println("Connection successfully");
	
	PreparedStatement pstmt=con.prepareStatement(deleteQuery);
	pstmt.setInt(1,userId);
	int i=pstmt.executeUpdate();
	System.out.println(i+"row deleted");
	pstmt.close();
	con.close();
		
		
	} 


//show all user method 

	public static List<User> showAllUser() {
		List<User> userList = new ArrayList<User>();

		String selectQuery = "select * from user_details where role_name='user'";

		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		Statement stmt;

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				userList.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),Long.parseLong(rs.getString(5)),rs.getString(6)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

public int findUserId(User currentUser) {
		
		String findUserID = "select user_id from user_details where user_name='"+currentUser.getName()+"'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt;
		
		int userId = 0;
		try {
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(findUserID);

			if (rs.next()) {
				//System.out.println(rs.getInt(2));
				userId = rs.getInt(1);
			}
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;



}
public  User findUser(int userId) {
	
	String findUserID = "select * from user_details where user_id="+userId;
	Connection con = ConnectionUtil.getDbConnection();
	Statement stmt;
	
	User user = null;
	try {
		stmt = con.createStatement();
//		
		ResultSet rs = stmt.executeQuery(findUserID);

		if (rs.next()) {

			//System.out.println(rs.getInt(1));
			user =new User(rs.getString(1),  rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
			//System.out.println(userId);
		}
	

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
}
//wallet
public int walletbalance(int id) throws SQLException {
	Connection con=ConnectionUtil.getDbConnection();
	String query="select wallet from user_details where user_id=? ";
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setInt(1, id);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	return -1;
}
//update wallet
public int updateWallet(int amount,int userId) throws SQLException {
	Connection con=ConnectionUtil.getDbConnection();
	String query="update user_details set wallet=? where userId=?";
	PreparedStatement pstmt=con.prepareStatement(query);
	pstmt.setInt(1,amount);
	pstmt.setInt(2, userId);
	int rs=pstmt.executeUpdate();
	pstmt.executeUpdate("commit");
	return rs;
	
	   
}
public User findUser(String email) {
	String findUserID = "select * from user_details where emailId='"+email+"'";
	Connection con = ConnectionUtil.getDbConnection();
	
	User user = null;
	ResultSet rs=null;
	try {
		Statement stmt = con.createStatement();
		 rs = stmt.executeQuery(findUserID);

		if (rs.next()) {

			//System.out.println(rs.getInt(1));
			user =new User(rs.getString(1),  rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
			//System.out.println(userId);
		}
	

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
	
}


//wallet update
public int  updatewall(User user) {
	
	Connection con = ConnectionUtil.getDbConnection();
	String query = "update user_details set wallet=wallet +  ? where email_id = ?";
	
	PreparedStatement pstm;
	int i =0;
	try {
		
		pstm = con.prepareStatement(query);
		
		pstm.setDouble(1, user.getWallet());
		pstm.setString(2,user.getEmailId());
		 i = pstm.executeUpdate();
		pstm.executeUpdate("commit");
		
		return i;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
//update profile
public void update(User user) {
	String updateQuery="update user_details set user_name=?,email_id=?,user_password=?,mobile_number=?,address=? where email_id=?";
	
	Connection con = ConnectionUtil.getDbConnection();
	try {
		PreparedStatement pst=con.prepareStatement(updateQuery);
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmailId());
		pst.setString(3, user.getPassword());
		pst.setLong(4,user.getMobileNumber());
		pst.setString(5, user.getAddress());
		
		int i=pst.executeUpdate();
		pst.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}



public List<User> myProfile(int userId){
	List<User> userList=new ArrayList<User>();
	String profile="select  * from user_details where user_id=?";
	Connection con=ConnectionUtil.getDbConnection();
	try {
		PreparedStatement pstmt=con.prepareStatement(profile);
		pstmt.setInt(1, userId);
		ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getDouble(8));
		userList.add(user);
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return userList;
	
}
public List<User> myProfileUpdate(int userId){
	List<User> userList=new ArrayList<User>();
	String profile="select  * from user_details where user_id=?";
	Connection con=ConnectionUtil.getDbConnection();
	try {
		PreparedStatement pstmt=con.prepareStatement(profile);
		pstmt.setInt(1, userId);
		ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getDouble(8));
		userList.add(user);
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return userList;
	
}

public boolean refundWallet(User user, int price) {
	Connection con = ConnectionUtil.getDbConnection();
	UserDaoImpl userdao = new UserDaoImpl();
	int userId = userdao.findUserId(user);
	String updateQuery1 = "update user_details set wallet=" + (user.getWallet() + price) + "where user_id="+user.getUserId();
		
	boolean flag = false;
	try {
		Statement stmt = con.createStatement();
		flag = stmt.executeUpdate(updateQuery1) > 0;

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return flag;

}


}



 



