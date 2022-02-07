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
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
.gfg {
        margin-left: 400px;
        margin-top: 30px;
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
        margin-top: -40px;
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