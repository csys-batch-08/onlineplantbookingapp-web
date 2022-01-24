<%@page import="com.onlineplantbooking.model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.daoImpl.CartDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    
    background-image: url("table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
</style>
</head>
<body>
<form action="showCart">
<% 
CartDaoImpl cartDao=new CartDaoImpl();
List<Cart> cartList=new ArrayList<Cart>();
%>
</table>
</thead>
<tr>
<th>cart Id</th>
<th>user Id</th>
<th>plant Id</th>
</tr>
</thead>
<tbody>
<% 
int i=0;
for (Cart showCart : cartList){
i++;
%>
<tr>
<td><%= i %></td>
<td><%= showCart.getCartId() %></td>
<td><%= showCart.getUserId() %></td>
<td><%= showCart.getPlantId() %></td>
</tr>
<%
}
%>

</tbody>
</table>
</form>
</body>
</html>