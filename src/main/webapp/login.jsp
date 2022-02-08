<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\login.css">
</head>
<body>
<div class="container"> 
<div class="card">
<form action="login" method="post">
<h2 style="color:white">Login Form</h2>
<input type="email" placeholder="EmailId" name="loginemail" required id="name" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}"><br>
<input type="password" placeholder="password" name="loginpassword" required id="name" pattern="[A-Za-z0-9@#$]{8,10}"><br>
<button type="submit" id="button">Submit</button>
</form>
</div>
</div>
</body>
</html>