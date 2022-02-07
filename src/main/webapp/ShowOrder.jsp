<%@page import="com.onlineplantbooking.daoImpl.UserDaoImpl"%>
<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.model.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.OrdersDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>plant Booking</title>
<style>
table,tr,th, td {
  border: 5px solid black;
  border-collapse: collapse;
}
body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
td{
font-size:150%
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
.menu-bar ul li a{
    text-decoration:none;
    font-size: 20px;
}

.one{
 top :100px;
 margin-left:300px;

 } 
   
</style>
</head>
<body>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li>
            <li><a href="ShowCancelOrderServlet">CANCELORDER</a>        
    </ul>
    </div>

</nav>
<div class="one">
<h1 style="text-align: left;"> Show Order</h1>
<table>
<tr>
<td><b>User Name</b></td>
<td><b>Product Name</b></td>
<td><b>Quantity</b></td>
<td><b>Price</b></td>
<td><b>Order Date</b></td>
</tr>


<c:forEach items="${showOrder}" var="order">
<tr>
<td>${order.user.name}</td>
<td>${order.product.plantName}</td>
<td>${order.quantity }</td>
<td>${order.totalPrice }</td>
<td>${order.orderDate }</td>
</c:forEach>
</table>
<br><br>
</div>

<c:set var="wallet" scope="session" value="${User}"/>
<center><strong><h2>Wallet Balane:</h2></strong>${wallet }</center>

</body>
</html>