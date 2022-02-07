<%@page import="com.onlineplantbooking.model.Orders"%>
<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.OrdersDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>orderCancel</title>


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

.one{
 top :100px;
 margin-left:300px;
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
 
 
 
</style>
</head>
<body>

<nav>
<div class="menu-bar">
<ul>
<li><a href="homePage.jsp">HOME</a></li>
<li><a href="aboutus.jsp">ABOUT</a></li>
<li><a href="contactus.jsp">CONTACT</a></li>
<li><a href="ProfileServlet">PROFILE</a></li>
<li><a href="ShowProductServlet">BUY</a></li>
<li><a href="UserCancelOrderServlet">CANCELHISTORY</a></li>
</ul> 
</div>
</nav>
<c:set var = "cancelOrder" scope = "session" value = "${cancel}"/>
	<c:if test="${not empty cancelOrder}">
			<h2><c:out value="${cancelOrder}" /></h2>
			<c:remove var="cancelOrder"/>
		</c:if>

	<c:if test="${not empty cancelsuccess }">
			<h2>successfully cancel</h2>
			<c:remove var="cancelsuccess"/>
		</c:if>
		
<c:set var = "refundAmt" scope = "session" value = "${refund}"/>
	<c:if test="${not empty refundAmt}">
			<h2><c:out value="${refundAmt}" /></h2>
			<c:remove var="refundAmt"/>
		</c:if>


<h1 style="text-align: center;"> Cancel Order</h1>
<div class="one"> 
<table>
<tr>
<td><b>User Name</b></td>
<td><b>Product Name</b></td>
<td><b>Quantity</b></td>
<td><b>Price</b></td>
<td><b>Order Date</b></td>
<td><b>cancel</b>
</tr>


<c:forEach items="${order}" var="orderList">
<tr>
<td>${orderList.user.name }</td>
<td>${orderList.product.plantName}</td>
<td>${orderList.quantity }</td>
<td>${orderList.totalPrice }</td>
<td>${orderList.orderDate }</td>
<td><a href="ordercancelserv?orderid=${orderList.orderid }&price=${orderList.totalPrice }">cancel</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>