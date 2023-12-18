<%@page import="com.ty.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1 {
  	background-color:orange;
	color:lime;
	font-size: 50px;
	font-family: sans-serif;
	text-align: center;
	
}
ul{
     display: flex;
     justify-content:space-between;
     margin-left: 1000px
     
}
li{
	color:navy;
	font-size: 20px;
	font-family: sans-serif;
	text-decoration: none;
	list-style: none;

}

li:hover {
	color: green;
	text-decoration: underline;
}
</style>
</head>
<body>
<% 
Employee employee=(Employee)session.getAttribute("my_employee");
%>
<h1>Welcome <%= employee.getName() %></h1>

<ul>
<li><a href="taskDetail.jsp">ViewTaskDetails</a></li>
<li><a href="updateTask.jsp">Update-Task</a></li>
<li><a href="logout">Logout</a></li>
</ul>
</body>
</html>