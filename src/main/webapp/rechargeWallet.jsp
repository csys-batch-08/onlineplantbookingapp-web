<%@page import="com.onlineplantbooking.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    
    background-image: url("table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
    
.one{
 top :100px;
 margin-left:600px;

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
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li>
            <li><a href="buyProduct.jsp">BUY</a>       
    </ul>
    </div>

</nav>

<%User user=(User) session.getAttribute("currentUser");%>
<form action="rechargeWallet">
<div class="one">
<h2>Recharge your Wallet</h2>       
 <label for="Amount">Amount:</label><br>
 <input type="text" name="amount" id="amount" placeholder="Enter Amount" Pattern="[1-9][0-9]+" maxlength="5" min="1" required><br><br>
         
<button type="submit">Recharge Wallet</button><br><br>
         

</div>
</form>
</body>
</html>