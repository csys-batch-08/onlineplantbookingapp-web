<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineplantbooking.model.*"%>
<%@page import="com.onlineplantbooking.daoImpl.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
    
    
 .one{
 top :100px;
 margin-left:550px;

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
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li>
            <li><a href="ProfileServlet">Profile</a></li>      
    </ul>
    </div>

</nav>



<br><br><br><br>

<div class="one">
<form action="ordersDetailServlet"  onmouseover="myFunct()">
<h1 >BUY YOUR PLANT</h1>
<c:forEach items="${currentPlant}" var="currentplant">
<label for="plantId" >PlantName:</label>

<input type="text" id="plantId" value="${currentplant.plantName}">
</c:forEach>
<br><br>
<b>Quantity:</b><input type="number" onkeyup="myFunct()" value=1 name="quantity" id="quantity" min="1"><br><br>
<b>Address:</b><input type="text"  name="addresss"   id="address" required><br><br>
<b>Total Price:</b><input type="number"  name="total"   id="price"><br><br>
<br>
<button type="submit" id="submit"> Submit</button>
<input type="reset">

</form>
</div>

<c:forEach items="${productPrice}" var="productPr">
<script type="text/javascript">
function myFunct() {
	var count=document.getElementById("quantity").value;
	var totalPrice=document.getElementById("price");
	console.log(count);
	totalPrice.value=count*${productPr.plantPrice} ;
	console.log(totalPrice.value);
	
}

</script>
</c:forEach>
<br><br>
</body>
</html>