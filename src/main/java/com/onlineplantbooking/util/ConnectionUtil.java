package com.onlineplantbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	public static Connection getDbConnection()
	{
	Connection con = null;

	try {
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	con = DriverManager.getConnection(url, "system", "oracle");
	}
	catch (ClassNotFoundException e)
	{
	e.getMessage();
	System.out.println("Driver jar doesn't there");
	}
	catch (SQLException e)
	{
	e.getMessage();
	System.out.println("url or username or password may wrong");
	}
	return con;
	}
	 public static  void closePreparedStatement(PreparedStatement preparedStatement,Connection connection) {
		 try {

		 if(preparedStatement!=null) {

		 preparedStatement.close();
		 }
		 if(connection!=null) {
		 connection.close();
		 }


		 } catch (SQLException e) {
		 e.printStackTrace();
		 }

		 }
		 public static void closeStatement (Statement statement,Connection connection) {
		 try {

		 if(statement!=null) {
		 statement.close();
		 }
		 if(connection!=null) {
		 connection.close();
		 }

		 }
		 catch (SQLException e) {
		 e.printStackTrace();
		 }

		 }
		 public static  void closePreparedStatement(PreparedStatement preparedStatement,Connection connection,ResultSet resultSet) {
		 try {
		 if(resultSet !=null) {
		 resultSet.close();
		 }

		 if(preparedStatement!=null) {

		 preparedStatement.close();
		 }
		 if(connection!=null) {
		 connection.close();
		 }


		 } catch (SQLException e) {
		 e.printStackTrace();
		 }

		 }
		 public static void closeStatement (Statement statement,Connection connection,ResultSet resultSet) {
		 try {
		 if(resultSet!=null) {
		 resultSet.close();
		 }

		 if(statement!=null) {
		 statement.close();
		 }
		 if(connection!=null) {
		 connection.close();
		 }

		 }
		 catch (SQLException e) {
		 e.printStackTrace();
		 }

		 }




}
