<%@page import="com.onlineplantbooking.daoImpl.UserDaoImpl"%>
<%@page import="com.onlineplantbooking.model.User" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Plant Booking</title>

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
font-size= 20px;
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


.center {
  margin-left: auto;
  margin-right: auto;
}   
</style>
</head>
<body>
<h1 style="text-align: center;"> Show User</h1>
<nav>
<div class="menu-bar">
        <ul>
            <li ><a href="homePage.jsp">HOME</a></li>
            <li><a href="aboutus.jsp">ABOUT</a></li>
            <li><a href="contactus.jsp">CONTACT</a></li> 
            <li><a href="admin.jsp">ADMIN</a>       
    </ul>
    </div>

</nav><br>
<form>
<table class="center">
<tr>
<td><b>User Id</b></td>
<td><b>Name</b></td>
<td><b>Email Id</b></td>
<td><b>Password</b></td>
<td><b>Mobile Number</b></td>
<td><b>Address</b></td>
</tr>
<%
UserDaoImpl userDao=new UserDaoImpl();
   List<User> userList=userDao.showAllUser();

   for(int i=0;i<userList.size();i++)
   {
	  
	   User user=userList.get(i);
  
  %> 
	  <tr>
	  <td><%= user.getUserId() %></td>
	  <td><%= user.getName() %></td>
	  <td><%= user.getEmailId() %></td>
	  <td><%= user.getPassword() %></td>
	  <td><%= user.getMobileNumber() %></td>
	  <td><%= user.getAddress() %></td>
	 
	   </tr>
	  <% } %>	  
	  <%  int userId=Integer.parseInt(request.getParameter("userId"));
	  userDao.deleteUser(userId); %>
	  </table>
	  </form>
</body>
</html>