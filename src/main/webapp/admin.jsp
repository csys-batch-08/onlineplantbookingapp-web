<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Admin Page</title>
<style>
body{
    
    background-image: url("table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
.one{
 top :100px;
 margin-left:500px;

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
    
    
    
 </style>
</head>
<body>
 <nav>
<div class="menu-bar">
        <ul>
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li>        
    </ul>
    </div>

</nav>        




<div class="one">
<h1>WELCOME ADMIN</h1>
<a href="showuser.jsp?userId=0"><h3>Show all user</h3></a>
<a href="showProduct.jsp?"><h3>Show all product</h3></a>
<a href="deleteProduct.jsp?plantId=0"><h3>Delete  product</h3></a>
<a href="insertProduct.jsp"><h3> Add New Product</h3></a>
<form action="DeleteProductServlet" >
</form>
</div>
</body>
</html>