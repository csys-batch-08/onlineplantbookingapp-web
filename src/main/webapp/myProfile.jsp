
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>user profile</title>
<link rel="stylesheet" type="text/css" href="asset\css\myProfile.css">
</head>
<body>

<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li>
            <li><a href="ShowProductServlet">BUY</a>       
    </ul>
    </div>

</nav>
    <h1 style="text-align: center;">My Profile</h1>
	<div class="one">
    <div class="gfg">
    <div class="gfg1">
    <div class="gfg2">
     <c:forEach items="${user}" var="userProfile">
    
    
	<strong>Name:</strong>${userProfile.name }<br><br>
	<strong>EmailId:</strong>${userProfile.emailId }<br><br>
	<strong>Password:</strong>${userProfile.password }<br><br>
	<strong>Mobile Number:</strong>${userProfile.mobileNumber }<br><br>

	<b>Wallet:</b>${userProfile.wallet}<br><br>
	<a href="rechargeWallet.jsp">Recharge Wallet</a>
	</c:forEach>
	</div>
	</div>
	</div>
	</div>



</body>
</html>