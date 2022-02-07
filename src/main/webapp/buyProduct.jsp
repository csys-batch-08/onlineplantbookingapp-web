
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of products</title>


<style>
body{
    background-color: pink;
    background-repeat:no repeat;
    background-size: cover;
    }
a{
text-decoration: none;
}
table,th,td{
border:5px solid black;
border-collapse:collapse;
}

table {
  width: 100%;
}

td {
  height: 50px;
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
.menu-bar ul li a input{
    text-decoration:none;
    font-size: 20px;
}
#searchbar {
	position: relative;
	top: 0px;
	left: 1050px;
}


</style>
</head>
<body>
<form action="SearchProductServlet" >
<h1 style="text-align: center;"> Show Plant</h1>

<div id="searchbar">
<label for="plan"></label> 
<input type="text" name="search"	id="plan"> 
<input type="submit" value="search">
</div>
</form>

<nav>
<div class="menu-bar">
        <ul>
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li> 
            <li><a href="ProfileServlet">PROFILE</a></li>
            <li><a href="ViewUserCartServlet">MYCART</a></li>
            <li><a href="ShowCancelOrderServlet">CANCELORDER</a></li>
        	<li><a href="offerServ">OFFER</a></li>
        	<li><a href="index.jsp">LOGOUT</a></li> 
            
            
    </ul>
    </div>
</nav>



<table align="center">
<tr>
<td><b>Plant</b></td>
<td><b>Plant Name</b></td>
<td><b>Plant Description</b></td>
<td><b>category Name</b></td>
<td><b>Plant Price</b></td>
<td><b>Buy Now</b></td>
<td><b>Add To Cart</b></td>
</tr>


	  
	  <c:forEach items="${ShowProduct}" var="product">
	  <tr>
	  <td><img alt="#alter" src="asset/images/${product.image}" width="200" height="200"></td>
	  <td>${product.plantName}</td>
	  <td>${product.plantDescription}</td>
	  <td>${product.categoryName}</td>
	  <td>${product.plantPrice}</td>
	  <td><a href="BuyPlantServlet?plantName=${product.plantName}&catName=${product.categoryName}">Buy</a>
	  <td><a href="CartInsertServlet?plantId=${product.plantId}&plantName=${product.plantName }&plantPrice=${product.plantPrice }">cart</a>
	  </td>
	  </tr>
	  </c:forEach>
	  </table>
	   </body>
	  </html>
	  
	  