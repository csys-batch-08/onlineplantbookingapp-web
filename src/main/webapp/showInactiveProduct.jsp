<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showInactivePlant</title>
<style>

table, tr, td,th {
  border: 5px solid black;
  border-collapse: collapse;
}
body{
       
    background-color:pink;
    background-repeat:no repeat;
    background-size: cover;
    }
td{
 font-size: 20px;
}    
.searchbar {
	position: relative;
	top: 0px;
	left: 1050px;
}
</style>
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
<td><b>Plant</b></td>
<td><b>Plant Name</b></td>
<td><b>Plant Description</b></td>
<td><b>category Name</b></td>
<td><b>Plant Price</b></td>
<td><b>Update</b></td>
</tr>


	  	  
	  <c:forEach items="${plantinactiveList}" var="Showproduct">	  
	  <tr>
	  <td><img alt="#alter" src="images1/${Showproduct.image }" width="200" height="200"></td>
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