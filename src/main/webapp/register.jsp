<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="asset\css\register.css">



</head>
<body>
<div class="registration-form">
  <div class="card">
    <div class="container"></div>
 <h1>Register</h1>
<form action="Register" method="post">
<p>User Name:</p>
<input type="text" name="username" placeholder="Username" pattern="[A-Z][a-z]{3,}" required>
<p>EmailId:</p>
<input type="email" name="email" placeholder="EmailId" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required>   
<P>Password:</P>   
<input type="password" name="password" placeholder="password" pattern="[A-Za-z0-9@#$]{8,10}" required >
<p>MobileNumber:</p>
<input type="number" name="mobilenumber" placeholder="MobileNumber" pattern="[0-9]{10}" required>
<p>Address:</p>
<input type="text" name="address" placeholder="Address" pattern="[A-Za-z0-9/,._]{3,}" required>
<button type="submit">Submit</button>
</form>
</div>
</div>
</body>
</html>