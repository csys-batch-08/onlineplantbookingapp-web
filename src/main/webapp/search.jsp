<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>
<link rel="stylesheet" type="text/css" href="asset\css\search.css">
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
  
	<table class="center">
		<tr>
			
			<th><strong>Plant Name</strong></th>
			<th><strong>Plant Description</strong></th>
			<th><strong>category Name</strong></th>
			<th><strong>Plant Price</strong></th>
			<th><strong>Buy Now</strong></th>
			<th><strong>Add To Cart</strong></th>
		</tr> 
		
 <c:forEach items="${list}" var="search">	
		
<tr>
 <td><img alt="#alter" src="asset/images/${search.image}" width="200" height="200"></td>
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

			