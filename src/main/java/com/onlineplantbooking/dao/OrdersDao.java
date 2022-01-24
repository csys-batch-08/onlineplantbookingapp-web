package com.onlineplantbooking.dao;

import java.util.List;

import com.onlineplantbooking.model.User;

public interface OrdersDao {
	public void insertOrder(OrdersDao order);
	public List<OrdersDao> viewOrders(User currentUser);
	public  void update(int quantity,int order_id);
	public  void delete(int orderId);

}
