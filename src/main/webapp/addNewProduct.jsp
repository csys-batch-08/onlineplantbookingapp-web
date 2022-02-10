<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add new Product</title>
<link rel="stylesheet" type="text/css"
	href="asset\css\addNewProduct.css">
</head>
<body>
	<h1>Add New Plant</h1>
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

	<form action="insertProduct" method="post">
		<div class="one">
			<table>
				<tr>
					<td>Enter Plant Name</td>
					<td><input type="text" name="plantname" id="plantname"
						required></td>
				</tr>
				<tr>
					<td>Enter plant description</td>
					<td><input type="text" name="plantdescription"
						id="plantdescription" required></td>
				</tr>
				<tr>
					<td>Enter plant price</td>
					<td><input type="number" name=" plantprice" id="plantprice"
						min="1" required></td>
				</tr>
				<tr>
					<td>Enter plant category</td>
					<td><select name="category" id="category">
							<option value="medicinal">medicinal</option>
							<option value="bamboo">bamboo</option>
							<option value="flowering">flowering plant</option>
							<option value="indoorplant">indoor plant</option>
							<option value="bonsaiplant">bonsai plant</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="file" name="plantimage"></td>
				</tr>



			</table>
			<input type="submit">
		</div>
	</form>
</body>
</html>