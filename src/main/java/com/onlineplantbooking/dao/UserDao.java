package com.onlineplantbooking.dao;

import java.util.List;


public interface UserDao {
	public void insertUser(UserDao userDao);
	public  UserDao validateUser(String emailId,String Password);
	public void update(String update);
	public void deleteUser(String delete);
	public  List<UserDao> showAllUser();
	public  int findUserId(UserDao currentUser);
	public  UserDao findUser(int userId);
}
