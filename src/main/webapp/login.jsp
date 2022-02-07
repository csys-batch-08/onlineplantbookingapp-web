<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
<style>
body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
    
#name{
  width: 300px;
  border-radius :20px;
  background:white;
  border-bottom:1px solid white;
  padding: 6px;
  margin-bottom: 30px; 
  font-size: 20px;
  color:rgb(50,50,50);
  border: none;
  outline: none;
}

#button{
  border-radius:none;
  padding: 10px 20px;
  background:hsl(323, 67%, 34%);
  color:white;
  margin-top: 10px;
  border:none ;
  outline: none;
  margin-left: none;
  font-size: 15px;
}
    

</style>
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