<%@page import="com.onlineplantbooking.daoImpl.UserDaoImpl"%>
<%@page import="com.onlineplantbooking.model.User" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Online Plant Booking</title>
<link rel="stylesheet" type="text/css" href="asset\css\showUser.css">

</head>
<body>
<h1 style="text-align: center;"> Show User</h1>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li> 
            <li><a href="admin.jsp">ADMIN</a>       
    </ul>
    </div>

</nav><br>
<form>
<table class="center">
<tr>
<td><strong>User Id</strong></td>
<td><strong>Name</strong></td>
<td><strong>Email Id</strong></td>
<td><strong>Password</strong></td>
<td><strong>Mobile Number</strong></td>
<td><strong>Address</strong></td>
</tr>

  
   <c:forEach items="${user}" var="User">
   
	  <tr>
	  <td>${User.userId }</td>
	  <td>${User.name}</td>
	  <td>${User.emailId}</td>
	  <td>${User.password}</td>
	  <td>${User.mobileNumber }</td>
	  <td>${User.address}</td>
	 
	   </tr>
	   
	 
	 </c:forEach>
	 </table>
	  
	  </form>
</body>
</html>