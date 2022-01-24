<%@page import="com.onlineplantbooking.model.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.OrdersDaoImpl"%>
<%@page import="com.onlineplantbooking.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view cancel order</title>
<style>
body{
    
    background-image: url("table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
table,tr,th, td {
  border: 5px solid black;
  border-collapse: collapse;
}
.one{
 top :100px;
 margin-left:400px;

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
            <li><a href="ordercancel.jsp">CANCELORDER</a></li>
            
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

<% User user=(User)session.getAttribute("currentUser");
OrdersDaoImpl orderDao=new OrdersDaoImpl();
List<Orders> orderList=orderDao.showCancelOrder(user);
for(int i=0;i<orderList.size();i++){
	Orders order=orderList.get(i);
	
%>
<tr>
<td><%=order.getProduct().getPlantName() %></td>
<td><%=order.getUser().getName() %></td>
<td><%=order.getQuantity() %></td>
<td><%=order.getTotalPrice() %></td>
<td><%=order.getAddress() %></td>
<td><%=order.getOrderDate() %></td>
<td><%=order.getOrderStatus() %></td>
</tr>

<%} %>
</table>
</div>
</body>
</html>