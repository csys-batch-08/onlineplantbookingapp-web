
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>offer  </title>
<link rel="stylesheet" type="text/css" href="asset\css\offer.css">
</head>
<body>
<form>
<nav>
<div class="menu-bar">
<ul>
<li><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li> 
            <li><a href="ProfileServlet">PROFILE</a></li>
            
</ul>
</div>
</nav>
</form>
<h2 style="text-align: center;">OFFER</h2>
<table>
<tr>
<td><strong>PLANT</strong></td>
<td><strong>PLANT NAME</strong></td>
<td><strong>PLANT DESCRIPTION</strong></td>
<td><strong>CATEGORY NAME</strong></td>
<td><strong>PLANT PRICE</strong></td>
<td><strong>BUY</strong></td>

</tr>
 <c:forEach items="${plantOffer}" var="offerplant">
<tr>
<td><img alt="#alter" src="asset/images/${offerplant.product.image }" width="200" height="200"></td>
<td>${offerplant.product.plantName}</td>
<td>${offerplant.product.plantDescription }</td>
<td>${offerplant.product.categoryName }</td>
<td><del>${offerplant.product.plantPrice  }</del>${offerplant.product.plantPrice *.90  }</td>
<td><a href="OfferDetailsServlet?plantName=${offerplant.product.plantName}&catName=${offerplant.product.categoryName }&offerprice=${offerplant.product.plantPrice *.90  }">Buy</a></td>

</tr>
 </c:forEach>
</table>

</body>
</html>