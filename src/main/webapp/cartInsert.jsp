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
<style>
<%String plantName=request.getParameter("plantName");
double price=Double.parseDouble(request.getParameter("plantPrice"));
int plantId=Integer.parseInt(request.getParameter("plantId"));
%>
</style>
<form action="InserCartServlet" >

<h2><b>Plant Id</b></h2><input type="text" value="<%=plantId %>" name="plantId"><br><br>
<h2><b>Plant Name</b></h2><input type="text" value="<%=plantName %>" name="plantname"><br><br>
<h2><b>Plant Price</b></h2><input type="text" value="<%=Math.round(price) %>" name="Price"><br><br>
<button type="submit"><b>submit</b></button><br><br>


</form>


</body>
</html>