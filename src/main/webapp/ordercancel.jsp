<%@page import="com.onlineplantbooking.model.Orders"%>
<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.OrdersDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    background-image: url("table.jpg");
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
<li><a href="myProfile.jsp">PROFILE</a></li>
<li><a href="buyProduct.jsp">BUY</a></li>
<li><a href="ViewCancelOrder.jsp">CANCELHISTORY</a></li>
</ul> 
</div>
</nav>

<%if(session.getAttribute("cancel")!=null){ %>
<h1> order Cancelled Already successfully</h1>
<%session.removeAttribute("cancel"); %>
<%} %>

<%if(session.getAttribute("cancelsuccess")!=null){
	%>
	<h2>Order Cancel Successfully</h2>
	<%session.removeAttribute("cancelsuccess"); %>
<%} %>
<%if(session.getAttribute("refund")!=null){ %>
<h1>amount refunded to your wallet</h1>
<%session.removeAttribute("refund"); %>
<%} %>

<h1 style="text-align: left;"> Cancel Order</h1>
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
<%
User user=(User)session.getAttribute("currentUser");
OrdersDaoImpl orderDao=new OrdersDaoImpl();


List<Orders> orderList=orderDao.ShowOrders(user);
for(int i=0;i<orderList.size();i++){
	Orders order=orderList.get(i);
%>
<tr>

<td><%= order.getUser().getName()%></td>
<td><%= order.getProduct().getPlantName() %></td>
<td><%= order.getQuantity() %></td>
<td><%= order.getTotalPrice() %></td>
<td><%= order.getOrderDate() %></td>
<td><a href="ordercancelserv?orderid=<%=order.getOrderid() %>&price=<%= order.getTotalPrice()%>">cancel</a></td>
</tr>

<%} %>

</table>
</div>
</body>
</html>