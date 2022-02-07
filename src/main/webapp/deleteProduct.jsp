<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List" %>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table,td,tr
{
border:5px solid black;
border-collapse:collapse;
}

body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
td{
font-size: 20px;
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
      
</style>
</head>
<body>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="index.jsp">HOME</a></li>
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