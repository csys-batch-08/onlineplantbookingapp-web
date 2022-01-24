<%@page import="com.onlineplantbooking.daoImpl.ProductDaoImpl"%>
<%@page import="java.util.List" %>
<%@page import="com.onlineplantbooking.model.Product"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table,td,tr
{
border:5px solid black;
border-collapse:collapse;
}

body{
    
    background-image: url("table.jpg");
    background-repeat:no repeat;
    background-size: cover;
    }
td{
font-size: 20px;
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
            <li><a href="admin.jsp">ADMIN</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li>        
    </ul>
    </div>

</nav>
<form action="updateProduct" method="post">
<h1 style="text-align: center;">Delete Product</h1>
<table>
<tr>
<td><b>Plant Id</b></td>
<td><b>Plant Name</b></td>
<td><b>Plant Description</b></td>
<td>category Name</td>
<td>Plant Price</td>
</tr>
<%ProductDaoImpl productDao=new ProductDaoImpl();
   List<Product> productList=productDao.showProduct();
  
   for(int i=0;i<productList.size();i++)
   {
	   Product product=productList.get(i);
  
	  %> 
	   <tr>
	  <td><%= product.getPlantId() %>
	  <td><%= product.getPlantName() %></td>
	  <td><%= product.getPlantDescription() %></td>
	  <td><%= product.getCategoryName() %></td>
	  <td><%= product.getPlantPrice() %></td>
	  <td><a href="deleteProduct.jsp?plantId=<%= product.getPlantId() %>"> Delete</a></td>
	  </tr>
	  <% } %>
	  
	  <% int plantId=Integer.parseInt(request.getParameter("plantId"));
	  productDao.deleteProduct(plantId); %>                                                           
	  </table>
	  </form>
</body>
</html>