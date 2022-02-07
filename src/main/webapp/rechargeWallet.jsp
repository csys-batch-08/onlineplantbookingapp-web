
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
    
    background-image: url("asset/images/table.jpg");
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
.gfg {
        margin-left:-100px;
        margin-top: 50px;
        border: 50px solid #009900;
        width: 300px;
        height: 200px;
        text-align: center;
        padding: 50px;
    }
      
    .gfg1 {
        font-size: 42px;
        font-weight: bold;
        color: #009900;
        margin-top: 5px;
        background-color: #c5c5db;
    }
      
    .gfg2 {
        font-size: 18px;
        font-weight: bold;
        background-color: #c5c5db;
    }
    
</style>   
   
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