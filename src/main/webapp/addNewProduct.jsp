<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="asset\css\addNewProduct.css">
</head>
<body>
<h1 style="text-align: center;">Add New Plant</h1>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="index.jsp">HOME</a></li>
            <li><a href="admin.jsp">ADMIN</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li>        
    </ul>
    </div>

</nav>

<form action="insertProduct" method="post" >
 <div class="one">
<label><h3>Enter Plant Name</h3></label>
<input type="text" name="plantname" id="plantname" required><br>
<label><h3>Enter plant description</h3></label>
<input type="text" name="plantdescription" id="plantdescription" required><br>
<label><h3>Enter plant price</h3></label>
<input type="number" name=" plantprice" id="plantprice" min="1" required><br>
<label><h3>Enter plant category</h3></label>
<select name="category" id="category">
<option value="medicinal">medicinal</option>
<option value="bamboo" >bamboo</option>
<option value="flowering">flowering plant</option>
<option value="indoorplant">indoor plant</option>
<option value="bonsaiplant">bonsai plant</option>
</select><br><br>
<input type="file" name="plantimage">
<button type="submit">Submit</button><br>
</div>
</form>
</body>
</html>