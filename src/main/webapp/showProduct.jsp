<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List" %>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>
<link rel="stylesheet" type="text/css" href="asset\css\showProduct.css">



</head>
<body>
<h1 style="text-align: center;"> Show Plant</h1>
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

<div class="searchbar">
<form action="SearchProductController">
<label for="plan"></label> <input type="text" name="search"	id="plan"> <input type="submit" value="search">
</form>
</div>
<form>
<table>
<tr>
<th><strong>Plant</strong></th>
<th><strong>Plant Name</strong></th>
<th><strong>Plant Description</strong></th>
<th><strong>category Name</strong></th>
<th><strong>Plant Price</strong></th>
<th><strong>Update</strong></th>
</tr>


	  	  
	  <c:forEach items="${product}" var="Showproduct">	  
	  <tr>
	  <td><img alt="#alter" src="asset/images/${Showproduct.image }" width="200" height="200"></td>
	  <td>${Showproduct.plantName}</td>
	  <td>${Showproduct.plantDescription}</td>
	  <td>${Showproduct.categoryName}</td>
	  <td>${Showproduct.plantPrice}</td>
	  <td><a href="UpdateServlet?productId=${Showproduct.plantId}">Update</a></td>
	  </tr>
	  </c:forEach>
	  </table>
	  </form>
	  </body>
	  </html>
	  




