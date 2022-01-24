<%@page import="com.onlineplantbooking.model.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>offer  </title>

<style>
table {
  border-collapse: collapse;
  width: 100%;
}

 td,th {
  text-align: left;
  padding: 8px;
}
tr:hover{
background-color: lime;
}

tr:nth-child(even) {
background-color:#DAF7A6 ;
}
tr:nth-child(odd) {
background-color:#EEE8AA;
}
a{
text-decoration: none;
}
body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/table.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
</style>
</head>
<body>
<%ResultSet resultSet=(ResultSet)session.getAttribute("plantOffer");
while(resultSet.next())
{%>
<h2>Offer</h2>
<table>
<tr>
<td>PLANT NAME</td>
<td>PLANT DESCRIPTION</td>
<td>CATEGORY NAME</td>
<td>PLANT PRICE</td>
<td>BUY</td>
<td>ADD TO CART</td>
</tr>
<tr>
<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getString(5) %></td>
<td><%=resultSet.getString(3) %>
<td><del><%=resultSet.getInt(2)%></del><%=resultSet.getInt(2)*.90 %></td>
<td><a href="OfferDetails.jsp?plantName=<%=resultSet.getString(1)%>&catName=<%=resultSet.getString(3)%>&offerprice=<%=resultSet.getInt(2)*.90%>">Buy</a></td>
<td><a href="cartInsert.jsp?plantId=<%=resultSet.getInt(4) %>&plantName=<%= resultSet.getString(1) %>&plantPrice=<%= resultSet.getInt(2)*.90%>">cart</a></td> 
	  
</tr>
</table>
<%} %>
</body>
</html>