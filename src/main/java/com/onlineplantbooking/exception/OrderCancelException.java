package com.onlineplantbooking.exception;

public class OrderCancelException extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Order Cancelled Already"
				+ "Amount Refund Your Wallet";
		
	}

}
