
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user profile</title>
<style>
body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
 .one{
 top :40px;
 margin-left:350px;

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


.main {
        font-size: 36px;
        font-weight: bold;
        Text-align: center;
    }
      
    .gfg {
        margin-left: 60px;
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
        margin-top: none;
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
    
    
	<b>Name:</b>${userProfile.name }<br><br>
	<b>EmailId:</b>${userProfile.emailId }<br><br>
	<b>Password:</b>${userProfile.password }<br><br>
	<b>Mobile Number:</b>${userProfile.mobileNumber }<br><br>

	<b>Wallet:</b>${userProfile.wallet}<br><br>
	<a href="rechargeWallet.jsp">Recharge Wallet</a>
	</c:forEach>
	</div>
	</div>
	</div>
	</div>



</body>
</html>