<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title> Admin Page</title>
<link rel="stylesheet" type="text/css" href="asset\css\admin.css">
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

<a href="ShowUserServlet">Show all User</a>
<a href="AdminUpdateProServlet">Show all product</a>
<a href="AdminDeleteproServlet">Delete  product</a>
<a href="showInactive">Show Inactive Plant</a>
<a href="addNewProduct.jsp">Add New Product</a>
<form action="DeleteProductServlet" >
</form>
</div>
</body>
</html>