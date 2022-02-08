
<%@page import="com.onlineplantbooking.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\rechargeWallet.css">   
   
</head>
<body>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li>
            <li><a href="BuyPlantServlet">BUY</a>       
    </ul>
    </div>

</nav>
 
<form action="rechargeWallet">
<div class="one">
<div class="gfg">
 <div class="gfg1">
 <div class="gfg2">
<h2>Recharge your Wallet</h2>       
<label for="Amount">Enter the Amount</label><br><br>
<input type="text" name="amount" id="amount" placeholder="Enter Amount" Pattern="[1-9][0-9]+" maxlength="5" min="1" required><br><br>         
<button type="submit">Recharge Wallet</button><br><br>  
</div>
</div>
</div>
</div>

</form>
</body>
</html>