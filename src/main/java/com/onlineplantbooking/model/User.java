package com.onlineplantbooking.model;

import java.io.Serializable;

public class User implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int userId;
		public User(int userId) {
			super();
			this.userId = userId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		private String name;
		private String emailId;
		private String password;
		private long mobileNumber;
		private String address;
		private double wallet;
		private String role;
		
		
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public double getWallet() {
			return wallet;
		}
		public void setWallet(double wallet) {
			this.wallet = wallet;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public User(String name, String emailId, String password, long mobileNumber, String address) {
			super();
			this.name = name;
			this.emailId = emailId;
			this.password = password;
			this.mobileNumber = mobileNumber;
			this.address = address;
		}
		public User(String name, String emailId, String password, long mobileNumber, String address,String role) {
			super();
			this.name = name;
			this.emailId = emailId;
			this.password = password;
			this.mobileNumber = mobileNumber;
			this.address = address;
		this.role=role;	
		}
		public User(String emailId, String password) {
			super();
			this.emailId = emailId;
			this.password = password;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(int int1, String string, String string2, String string3, long parseLong, String string4) {
			this.userId=int1;// TODO Auto-generated constructor stub
			this.name = string;
			this.emailId = string2;
			this.password = string3;
			this.mobileNumber = parseLong;
			this.address = string4;
			
		}
		public User(int int1, String string, String string2, String string3, long long1, String string4,
				String string5,double wallet) {
			this.userId=int1;// TODO Auto-generated constructor stub
			this.name = string;
			this.emailId = string2;
			this.password = string3;
			this.mobileNumber = long1;
			this.address = string4;
			this.role=string5;
			this.wallet=wallet;
			// TODO Auto-generated constructor stub
		}
		public User(Double wallet2, String email) {
			this.wallet=wallet2;
			this.emailId=email;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", emailId=" + emailId + ", password=" + password + ", mobileNumber="
					+ mobileNumber + ", address=" + address + "]";
		}
		
}
