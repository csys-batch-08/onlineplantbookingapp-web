<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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