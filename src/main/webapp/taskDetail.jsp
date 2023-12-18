<%@page import="com.ty.dto.Employee"%>
<%@page import="com.ty.dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% EmployeeDao dao=new EmployeeDao();
  Employee employee=(Employee)session.getAttribute("my_employee");
  List<Task> tasks=employee.getTasks(); 
%>
<table border="2px" cellpadding="5px" cellspacing="0px">
<tr>
<th>Id</th>
<th>Task-Description</th>
<th>Task-Status</th>
</tr>
<% for(Task task: tasks){
		 %>
		 <tr>
		 <td><%= task.getId() %></td>
		  <td><%= task.getDescription() %></td>
		   <td><%= task.getStatus() %></td>
		 </tr>
<%} %>
</table>
</body>
</html>