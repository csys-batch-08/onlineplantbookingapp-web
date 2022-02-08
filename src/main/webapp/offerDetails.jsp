<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\offerDetails.css">

</head>
<body>
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

<br><br><br><br>
<c:forEach items="${productOffer}" var="offer">
<div class="one">
<form action="ordersDetailServlet"  onmouseover="myFunct()">
<h1 >BUY YOUR PLANT</h1>
<label for="plantId" ><b>PlantName:</b></label>
<input type="text" value="${offer.plantName }"><br><br>
<b>Quantity:</b><input type="number" onkeyup="myFunct()" value=1 name="quantity" id="quantity" min="1"><br><br>
<b>Address:</b><input type="text"  name="addresss"   id="address" required><br><br>
<b>Total Price:</b><input type="number"  name="total" id="price"><br><br>
<br>

<button type="submit" id="submit"> Submit</button>
</form>
</div>

<script type="text/javascript">
function myFunct() {
	var count=document.getElementById("quantity").value;
	var totalPrice=document.getElementById("price");
	console.log(count);
	
	totalPrice.value=Math.round(count*${offer.plantPrice});
	console.log(totalPrice.value);
	
}

</script>
</c:forEach>
<br><br>

</body>
</html>