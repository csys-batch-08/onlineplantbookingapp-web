<%@page import="com.onlineplantbooking.model.User"%>
<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List" %>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>



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
a{
text-decoration: none;
}    
td{
 font-size: 20px;
}    
.searchbar {
	position: relative;
	top: 0px;
	left: 1050px;
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
.menu-bar ul li a input{
    text-decoration:none;
    font-size: 20px;
}

</style>
</head>
<body>
<h1 style="text-align: center;"> Show Plant</h1>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li> 
            <li><a href="admin.jsp">ADMIN</a>       
    </ul>
    </div>

</nav><br>

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


	  	  
	  <c:forEach items="${product}" var="Showproduct">	  
	  <tr>
	  <td><img alt="#alter" src="asset/images/${Showproduct.image }" width="200" height="200"></td>
	  <td>${Showproduct.plantName}</td>
	  <td>${Showproduct.plantDescription}</td>
	  <td>${Showproduct.categoryName}</td>
	  <td>${Showproduct.plantPrice}</td>
	  <td><a href="UpdateServlet?productId=${Showproduct.plantId}">Update</a></td>
	  </tr>
	  </c:forEach>
	  	  
	  </table>
	  </form>
	  </body>
	  </html>
	  
	  
	 	  
	  
	  
	  
   
   
   




