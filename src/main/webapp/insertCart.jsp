<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    
    background-image:url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
</style>
</head>


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