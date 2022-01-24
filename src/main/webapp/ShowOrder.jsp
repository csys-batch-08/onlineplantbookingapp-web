<%@page import="com.onlineplantbooking.daoImpl.UserDaoImpl"%>
<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.model.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.OrdersDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    background-image: url("table.jpg");
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
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li>
            <li><a href="ordercancel.jsp">CANCELORDER</a>        
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

<%OrdersDaoImpl orderDao=new OrdersDaoImpl();
List<User> userList=(List<User>) session.getAttribute("UpdateList");

List<Orders> orderList=orderDao.ShowOrder(userList.get(0));
for(int i=0;i<orderList.size();i++){
	Orders order=orderList.get(i);
%>
<tr>
<td><%= order.getUser().getName()%></td>
<td><%= order.getProduct().getPlantName() %></td>
<td><%= order.getQuantity() %></td>
<td><%= order.getTotalPrice() %></td>
<td><%= order.getOrderDate() %></td>
</tr>
<%} %>
</table>
<br><br>
</div>
<center><strong><h2>Wallet Balane:</h2></strong><lable><%=userList.get(0).getWallet() %></lable></center>
<!--  <a href="rechargeWallet.jsp">Wallet</a> -->
</body>
</html>