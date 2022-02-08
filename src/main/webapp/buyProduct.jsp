<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>
<link rel="stylesheet" type="text/css" href="asset\css\buyProduct.css">
</head>
<body>
<form action="SearchProductServlet" >
<h1 style="text-align: center;"> Show Plant</h1>

<div id="searchbar">
<label for="plan"></label> 
<input type="text" name="search"	id="plan"> 
<input type="submit" value="search">
</div>
</form>

<nav>
<div class="menu-bar">
        <ul>
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li> 
            <li><a href="ProfileServlet">PROFILE</a></li>
            <li><a href="ViewUserCartServlet">MYCART</a></li>
            <li><a href="ShowCancelOrderServlet">CANCELORDER</a></li>
        	<li><a href="offerServ">OFFER</a></li>
        	<li><a href="index.jsp">LOGOUT</a></li> 
            
            
    </ul>
    </div>
</nav>



<table class="center">
<tr>
<td><strong>Plant</strong></td>
<td><strong>Plant Name</strong></td>
<td><strong>Plant Description</strong></td>
<td><strong>category Name</strong></td>
<td><strong>Plant Price</strong></td>
<td><strong>Buy Now</strong></td>
<td><strong>Add To Cart</strong></td>
</tr>


	  
	  <c:forEach items="${ShowProduct}" var="product"> 
	  <tr>
	   <td><img alt="#alter" src="asset/images/${product.image}" width="200" height="200"></td>
	  <td>${product.plantName}</td>
	  <td>${product.plantDescription}</td>
	  <td>${product.categoryName}</td>
	  <td>${product.plantPrice}</td>
	  <td><a href="BuyPlantServlet?plantName=${product.plantName}&catName=${product.categoryName}">Buy</a>
	  <td><a href="CartInsertServlet?plantId=${product.plantId}&plantName=${product.plantName }&plantPrice=${product.plantPrice }">cart</a>
	  </td>
	  
	   </tr>
	   </c:forEach>
	   
	 
	 
	  </table>
	   </body>
	  </html>
	  
	  