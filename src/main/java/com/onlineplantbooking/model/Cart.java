package com.onlineplantbooking.model;

public class Cart {
	     int cartId; 
	     int userId;
         int plantId;
         public int getCartId() {
			return cartId;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getPlantId() {
			return plantId;
		}
		public void setPlantId(int plantId) {
			this.plantId = plantId;
		}
		
         @Override
		public String toString() {
			return "Cart [userId=" + userId + ", plantId=" + plantId + "]";
		}
		public Cart() {
			super();
			
		}
		public Cart(int userId, int plantId) {
			super();
			this.userId = userId;
			this.plantId = plantId;
		}
		
         
		
}		