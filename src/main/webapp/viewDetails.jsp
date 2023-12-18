<%@page import="com.ty.dto.Task"%>
<%@page import="com.ty.dto.Employee"%>
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
  List<Employee> employees=dao.findAllEmployees();
  
  
%>
 <table border="2px" cellpadding="5px" cellspacing="0px">
 <tr>
 <th>Id</th>
 <th>Name</th>
 <th>Email</th>
 <th>Role</th>
 <th>Salary</th>
 <th>Task-Description</th>
  <th>Task-Status</th>
 </tr>
 <% for(Employee employee:employees)
	
	 {%>
	 
	 <tr>
	 <td  ><h4><%= employee.getId() %></h4></td>
	 <td ><h4><%= employee.getName() %></h4></td>
	<td ><h4><%= employee.getEmail() %></h4></td>
	 <td ><h4><%= employee.getRole() %></h4></td>
	 <td ><h4><%= employee.getSalaray() %></h4></td>	 
	 <td >
	 <% for(Task task: employee.getTasks()){
		 %>
		<h4><%= task.getDescription() %> </h4>
		 <%} %>
	 </td>
	 <td>
	
	 <% for(Task task: employee.getTasks()){
		 %>
		<h4><%= task.getStatus() %> </h4>
		<% }%>
	 </td>
	 </tr>
	 <%} %>
 </table>

</body>
</html>