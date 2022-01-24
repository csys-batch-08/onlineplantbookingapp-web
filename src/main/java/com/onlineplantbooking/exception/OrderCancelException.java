package com.onlineplantbooking.exception;

public class OrderCancelException extends Exception {
	@Override
	public String getMessage() {
		return "Order Cancelled Already";
		
	}

}
