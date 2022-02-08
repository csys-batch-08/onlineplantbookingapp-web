<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>showInactivePlant</title>
<link rel="stylesheet" type="text/css" href="asset\css\ShowInactiveProduct.css">
</head>
<body>
<h1 style="text-align: center;"> Show Plant</h1>
<div class="searchbar">
<form action="SearchProductController">
<label for="plan"></label> <input type="text" name="search"	id="plan"> <input type="submit" value="search">
</form>
</div>
<form>
<table>
<tr>
<td><strong>Plant</strong></td>
<td><strong>Plant Name</strong></td>
<td><strong>Plant Description</strong></td>
<td><strong>category Name</strong></td>
<td><strong>Plant Price</strong></td>
<td><strong>Update</strong></td>
</tr>


	  	  
	  <c:forEach items="${plantinactiveList}" var="Showproduct">	  
	  <tr>
	 <td><img alt="#alter" src="asset/images/${Showproduct.image }" width="200" height="200"></td>
	  <td>${Showproduct.plantName}</td>
	  <td>${Showproduct.plantDescription}</td>
	  <td>${Showproduct.categoryName}</td>
	  <td>${Showproduct.plantPrice}</td>
	  <td><a href="inactivePlantUpdate?productId=${Showproduct.plantId}">ACTIVE</a></td>
	  </tr>
	  </c:forEach>
	  	  
	  </table>
	  </form>
</body>
</html>