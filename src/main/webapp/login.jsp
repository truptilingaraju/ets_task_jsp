<%@page import="com.ty.dto.Employee"%>
<%@page import="com.ty.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

body {
	margin-top: 100px;
}

h1 {
  	
	color:navy;
	font-size: 50px;
	font-family: sans-serif;
	text-align: center;
	
}



form {
	display: flex;
	flex-direction: column;
	align-items: center;
	background-color: gray;
}

label {
	color: white;
	font-size: 15px;
	font-family: cursive;
}

input {
	box-shadow: 0px 0px 15px white;
}

a{
	color: black;
}
button {
	
	background: black;
	color: white;
	font-family: monospace;
	font-size: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 15px white;
}

</style>
</head>
<body>
<% EmployeeDao dao=new EmployeeDao(); %>
<form action="login">
<label>Email</label>
<input type="email" name="user_email">
<br><br>
<label>Password</label>
<input type="password" name="user_password">
<br><br>
<button>login</button>

   <%
      
	if(dao.getManager()==false)
	{%>
		<h3><a href="register.jsp">new User?Register</a></h3>
    <% } %>
</form>

</body>
</html>