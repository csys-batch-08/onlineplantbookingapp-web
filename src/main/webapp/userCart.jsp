<%@page import="com.onlineplantbooking.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.CartDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
font-size:20px;

}




</style>
</head>
<body>
<h1>Show cart</h1>
<table>
<tr>
<td>plant Name</td>
<td>plant Description</td>
<td>plant price</td>
<td>category </td>

</tr>
<%
CartDaoImpl cartDao=new CartDaoImpl();

int userId=(int)session.getAttribute("userId");

List<Product> productList=cartDao.fetchCart(userId);
String name=(String)session.getAttribute("plantName");

for(int i=0;i<productList.size();i++)
{
	Product product=productList.get(i);
%>
<tr>
<td><%= product.getPlantName()%></td>
<td><%= product.getPlantDescription() %></td>
<td><%= product.getPlantPrice() %></td>
<td><%= product.getCategoryName() %></td>
<td><a href="orderDetails.jsp?plantName=<%=product.getPlantName()%>&catName=<%=product.getCategoryName()%>">Buy</a></td>

</tr>
<%} %>
</table>
</body>
</html>

