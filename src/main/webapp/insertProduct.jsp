<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    
    background-image: url(" table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
    .menu-bar{
    background:#ace600;
    text-align: center;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color: #fff;
}
.menu-bar ul li
{
width: 100px;
margin: 15px;
padding: 4px;
}
.menu-bar ul li a{
    text-decoration:none;
    font-size: 20px;
}
.one{
 top :100px;
 margin-left:600px;

 } 
   
    
</style>
</head>
<body>
<h1 style="text-align: center;">Add New Plant</h1>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="admin.jsp">ADMIN</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li>        
    </ul>
    </div>

</nav>

<form action="insertProduct" method="post" >
 <div class="one">
<lable><h2>Enter Plant Name</h2></lable>
<input type="text" name="plantname" id="plantname" required><br>
<lable><h2>Enter plant description</h2></lable>
<input type="text" name="plantdescription" id="plantdescription" required><br>
<lable><h2>Enter plant price</h2></lable>
<input type="number" name=" plantprice" id="plantprice" min="1" required><br>
<lable><h2>Enter plant category</h2></lable>
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