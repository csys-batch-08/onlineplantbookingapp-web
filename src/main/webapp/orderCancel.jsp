
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>orderCancel</title>
<link rel="stylesheet" type="text/css" href="asset\css\orderCancel.css">

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
<fmt:parseDate value="${orderList.orderDate}" pattern="yyyy-MM-dd HH:mm" var="orderDate" type="date" />
<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${orderDate}" />	

<td><a href="ordercancelserv?orderid=${orderList.orderid }&price=${orderList.totalPrice }">cancel</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>