<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete product</title>
<link rel="stylesheet" type="text/css" href="asset\css\deleteProduct.css">
</head>
<body>
	<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="index.jsp">HOME</a></li>
				<li><a href="admin.jsp">ADMIN</a></li>
				<li><a href="aboutUs.jsp">ABOUT</a></li>
				<li><a href="contactUs.jsp">CONTACT</a></li>
			</ul>
		</div>

	</nav>
	<form action="updateProduct" method="post">
		<h1 style="text-align: center;">Delete Product</h1>
		<table>
			<tr>
				<td><b>Plant Id</b></td>
				<td><b>Plant Name</b></td>
				<td><b>Plant Description</b></td>
				<td><b>category Name</b></td>
				<td><b>Plant Price</b></td>
			</tr>



			<c:forEach items="${product}" var="Showproduct">

				<tr>
					<td>${Showproduct.plantId }</td>
					<td>${Showproduct.plantName }</td>
					<td>${Showproduct.plantDescription }</td>
					<td>${Showproduct.categoryName }</td>
					<td>${Showproduct.plantPrice }</td>
					<td><a href="deletePro?plantId=${Showproduct.plantId}">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>