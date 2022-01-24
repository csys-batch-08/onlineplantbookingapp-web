<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>


<style>
body {
	background-color: pink;
	background-repeat: no repeat;
	background-size: cover;
}

table, th, td {
	border: 5px solid black;
	border-collapse: collapse;
}

table {
	width: 100%;
}

td {
	height: 50px;
	font-size: 20px;
}

.menu-bar {
	background: #ace600;
	text-align: center;
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #fff;
}

.menu-bar ul li {
	width: 100px;
	margin: 15px;
	padding: 4px;
}

.menu-bar ul li a {
	text-decoration: none;
	font-size: 20px;
}
</style>
</head>
<body>
<%String search=request.getParameter("search");
ProductDaoImpl productDao=new ProductDaoImpl();
List<Product> productList=productDao.filterPlant(search);%>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li> 
            <li><a href="myProfile.jsp">PROFILE</a></li>
            </ul>
            </div>
            </nav>

    <h1 style="text-align: center;"> Show Plant</h1> 
  
	<table align="center">
		<tr>
			
			<td><b>Plant Name</b></td>
			<td><b>Plant Description</b></td>
			<td><b>category Name</b></td>
			<td><b>Plant Price</b></td>
			<td><b>Buy Now</b></td>
			<td><b>Add To Cart</b></td>
		</tr>

		<%
User user = (User) session.getAttribute("CurrentUser");
for(int i=0;i<productList.size();i++){
	Product product=productList.get(i);
%>

		<tr>
		    
			<td><%= product.getPlantName() %></td>
			<td><%= product.getPlantDescription() %></td>
			<td><%= product.getCategoryName() %></td>
			<td><%= product.getPlantPrice() %></td>
			<td><a
				href="orderDetails.jsp?plantName=<%=product.getPlantName()%>&catName=<%=product.getCategoryName()%>">Buy</a></td>
			<td><a
				href="cartInsert.jsp?plantId=<%=product.getPlantId() %>&plantName=<%= product.getPlantName() %>&plantPrice=<%=product.getPlantPrice() %>">cart</a>
		</tr>
		<% } %>
	</table>

</body>
</html>

