package com.onlineplantbooking.dao;

import com.onlineplantbooking.model.User;

public interface AdminDao {
	public  User validateAdmin(String emailId,String password);
	
	

}
