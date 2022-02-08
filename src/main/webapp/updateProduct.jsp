<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\updateProduct.css">

</head>
<body>
<h1 style="text-align: center;"> Update Product Price</h1>
<div class="gfg">
<div class="gfg1">
<div class="gfg2">
<c:set var="plantId" scope="session" value="${plantID}"/>
<form action="updateProduct">
<h2>Plant Id</h2><input type="text" name="plantId" value="${plantId}">
<h2>plant price</h2><input type="number" name="plantPrice" id="plantPrice"><br><br>
<input type="submit">
</form>
</div>
</div>
</div>
</body>
</html>