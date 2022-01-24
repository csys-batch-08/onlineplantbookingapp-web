<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<style>
{
    padding:0;
    margin:0;
    
}
body{
    
    background-image: url("home.jpeg.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
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

.button
{
    background-color: rgba(218, 19, 19, 0.555);
    text-decoration: none;
    display: -moz-inline-box;
    padding: 5px 5px;
    
}
</style>
</head>
<body>
<h1 style="text-align: center;"> Online Plant Shop</h1>
<nav>
<div class="menu-bar">
        <ul>
            
            <li><a href="login.jsp">LOGIN</a></li>
            <li><a href="index.jsp">REGISTER</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li>   
               
    </ul>
    </div>
    <br>
    </nav>
    
</html>