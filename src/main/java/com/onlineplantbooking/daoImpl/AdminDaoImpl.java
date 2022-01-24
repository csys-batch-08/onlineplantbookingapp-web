package com.onlineplantbooking.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineplantbooking.model.User;
import com.onlineplantbooking.util.ConnectionUtil;

public class AdminDaoImpl {

		public static User validateAdmin(String emailId,String password) {
			
			String validateQuery="select * from user_details where role_name='admin' and Email_id='" +emailId +"'and user_password='"+password+"'";
			Connection con=ConnectionUtil.getDbConnection();
			User user=null;
			try {
				java.sql.Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(validateQuery);
				
				if(rs.next()) {
				 user=new User(rs.getString(2),emailId,password,rs.getLong(5),rs.getString(6));
				}
				
			}
			catch(SQLException e) {
				e.getMessage();
				
			}
			 
			return user;
			
		}

}
