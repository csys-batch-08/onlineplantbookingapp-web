<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\userCart.css">


</head>
<body>
<h1 style="text-align: center;">My Cart</h1>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li> 
            <li><a href="ProfileServlet">PROFILE</a></li>
</ul>
</div>
</nav>            
<table>
<tr>
<td><b>plant Name</b></td>
<td><b>plant Description</b></td>
<td><b>plant price</b></td>
<td><b>category</b></td>
</tr>
<c:forEach items="${plantList}" var="plant">
<tr>
<td>${plant.plantName}</td>
<td>${plant.plantDescription}</td>
<td>${plant.plantPrice}</td>
<td>${plant.categoryName}</td>
<td><a href="orderDetails.jsp?plantName=${plant.plantName}&catName=${plant.categoryName}">Buy</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>

