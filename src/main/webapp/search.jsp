<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>


<style>
body {
	background-color: pink;
	background-repeat: no repeat;
	background-size: cover;
}

table, th, td {
	border: 5px solid black;
	border-collapse: collapse;
}

table {
	width: 100%;
}

td {
	height: 50px;
	font-size: 20px;
}

.menu-bar {
	background: #ace600;
	text-align: center;
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #fff;
}

.menu-bar ul li {
	width: 100px;
	margin: 15px;
	padding: 4px;
}

.menu-bar ul li a {
	text-decoration: none;
	font-size: 20px;
}
</style>
</head>
<body>

<nav>
<div class="menu-bar">
        <ul>
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li> 
            <li><a href="ProfileServlet">PROFILE</a></li>
            </ul>
            </div>
            </nav>

    <h1 style="text-align: center;"> Show Plant</h1> 
  
	<table align="center">
		<tr>
			
			<td><b>Plant Name</b></td>
			<td><b>Plant Description</b></td>
			<td><b>category Name</b></td>
			<td><b>Plant Price</b></td>
			<td><b>Buy Now</b></td>
			<td><b>Add To Cart</b></td>
		</tr> 
		
 <c:forEach items="${list}" var="search">	
		
<tr>

<td>${search.plantName}</td>
<td>${search.plantDescription}</td>
<td>${search.categoryName}</td>
<td>${search.plantPrice}</td>	
<td><a href="orderDetails.jsp?plantName=${search.plantName}&catName=${search.categoryName}">Buy</a>
 <td><a href="insertCart.jsp?plantId=${search.plantId}&plantName=${search.plantName }&plantPrice=${search.plantPrice }">cart</a> 
</tr>
</c:forEach>

</table>

</body>
</html>

