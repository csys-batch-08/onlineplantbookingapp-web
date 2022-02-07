<%@page import="com.onlineplantbooking.model.Product"%>
<%@page import="java.sql.ResultSet"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>offer  </title>
<style>
table,td,tr
{
border:5px solid black;
border-collapse:collapse;
}

body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
td{
font-size: 20px;
}

.menu-bar{
    background:#ace600;
    text-align: center;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color: #fff;
}
.menu-bar ul li
{
width: 100px;
margin: 15px;
padding: 4px;
}
.menu-bar ul li a input{
    text-decoration:none;
    font-size: 20px;
}  
</style>
</head>
<body>
<form>
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
</form>
<h2 style="text-align: center;">OFFER</h2>
<table>
<tr>
<td><b>PLANT</b></td>
<td><b>PLANT NAME</b></td>
<td><b>PLANT DESCRIPTION</b></td>
<td><b>CATEGORY NAME</b></td>
<td><b>PLANT PRICE</b></td>
<td><b>BUY</b></td>

</tr>
 <c:forEach items="${plantOffer}" var="offerplant">
<tr>
<td><img alt="#alter" src="asset/images/${offerplant.product.image }" width="200" height="200"></td>
<td>${offerplant.product.plantName}</td>
<td>${offerplant.product.plantDescription }</td>
<td>${offerplant.product.categoryName }</td>
<td><del>${offerplant.product.plantPrice  }</del>${offerplant.product.plantPrice *.90  }</td>
<td><a href="OfferDetailsServlet?plantName=${offerplant.product.plantName}&catName=${offerplant.product.categoryName }&offerprice=${offerplant.product.plantPrice *.90  }">Buy</a></td>

</tr>
 </c:forEach>
</table>

</body>
</html>