<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>plant Booking</title>
<link rel="stylesheet" type="text/css" href="asset\css\showOrder.css">
</head>
<body>
	<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="index.jsp">HOME</a></li>
				<li><a href="aboutUs.jsp">ABOUT</a></li>
				<li><a href="contactUs.jsp">CONTACT</a></li>
				<li><a href="ShowCancelOrderServlet">CANCELORDER</a>
			</ul>
		</div>
	</nav>
	<div class="one">
		<h1>Show Order</h1>
		<table>
			<tr>
				<th>User Name</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Order Date</th>
			</tr>
			<c:forEach items="${showOrder}" var="order">
				<tr>
					<td>${order.user.name}</td>
					<td>${order.product.plantName}</td>
					<td>${order.quantity }</td>
					<td>${order.totalPrice }</td>
					<fmt:parseDate value="${order.orderDate}" pattern="yyyy-MM-dd HH:mm" var="orderDate" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${orderDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:set var="wallet" scope="session" value="${User}" />
	<h3>Wallet Balance:${wallet }</h3>
</body>
</html>
