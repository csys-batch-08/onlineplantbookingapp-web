<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\insertCart.css">
</head>
<h1 style="text-align: center;"> Add To Cart</h1>
<body>
<c:set var="plantName"  scope="session" value="${plantname}"/>
<c:set var="plantPrice" scope="session" value="${plantprice}"/>
<c:set var="plantId"    scope="session" value="${plantid}"/>

<form action="InserCartServlet" >
<h2><b>Plant Id</b></h2><input type="text" value="${plantId }" name="plantId"><br><br>
<h2><b>Plant Name</b></h2><input type="text" value="${plantName}" name="plantname"><br><br>
<h2><b>Plant Price</b></h2><input type="text" value="${plantPrice}" name="Price"><br><br>
<button type="submit"><b>submit</b></button><br><br>
</form>
</body>
</html>