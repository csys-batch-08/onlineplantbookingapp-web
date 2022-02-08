
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view cancel order</title>
<link rel="stylesheet" type="text/css" href="asset\css\viewCancelOrder.css">
</head>
<body>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li> 
            <li><a href="ShowCancelOrderServlet">CANCELORDER</a></li>
            
</ul>
</div>
</nav>
<h1 style="text-align: center;"> Show Cancel Order</h1>
<div class="one">
<table>
<tr>
<th>Plant Name</th>
<th>User Name</th>
<th>Quantity</th>
<th>Total Price</th>
<th>Address</th>
<th>Order Date</th>
<th>Order Status</th>
</tr>



<c:forEach items="${order}" var="orderList">
<tr>
<td>${orderList.product.plantName}</td>
<td>${orderList.user.name }</td>
<td>${orderList.quantity }</td>
<td>${orderList.totalPrice }</td>
<td>${orderList.address }</td>
<fmt:parseDate value="${orderList.orderDate}" pattern="yyyy-MM-dd HH:mm" var="orderDate" type="date" />
<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${orderDate}" />	
<td>${orderList.orderStatus }</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>