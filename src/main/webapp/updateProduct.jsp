<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    
    background-image: url("table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }

</style>
</head>
<body>

<%int plantId=Integer.parseInt(request.getParameter("productId")); %>
<form action="updateProduct">

<h2>Plant Id</h2><input type="text" name="plantId" value="<%=plantId%>">
<h2>plant price</h2><input type="number" name="plantPrice" id="plantPrice"><br><br>
<input type="submit">

</form>
</body>
</html>