<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Admin Page</title>
<style>
body{
    
    background-image: url("asset/images/table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
a{
text-decoration: none;
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
            <li ><a href="index.jsp">HOME</a></li>
            <li><a href="aboutUs.jsp">ABOUT</a></li>
            <li><a href="contactUs.jsp">CONTACT</a></li>
            <li><a href="index.jsp">LOGOUT</a></li>       
    </ul>
    </div>

</nav>        




<div class="one">
<h1>WELCOME ADMIN</h1>

<a href="ShowUserServlet"><h3>Show all User</h3></a>
<a href="AdminUpdateProServlet"><h3>Show all product</h3></a>
<a href="AdminDeleteproServlet"><h3>Delete  product</h3></a>
<a href="showInactive"><h3>Show Inactive Plant</h3></a>
<a href="addNewProduct.jsp"><h3>Add New Product</h3></a>
<form action="DeleteProductServlet" >
</form>
</div>
</body>
</html>