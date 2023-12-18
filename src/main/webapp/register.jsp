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
  	
	color:maroon;
	font-size: 50px;
	font-family: sans-serif;
	text-align: center;
	
}



form {
	display: flex;
	flex-direction: column;
	align-items: center;
	background-color: olive;
}

label {
	color:black;
	font-size: 15px;
	font-family: cursive;
}

input {
	box-shadow: 0px 0px 15px white;
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
<form action="manager">
<label>Name</label>
<input type="text" name="user_name">
<br><br>
<label>Email</label>
<input type="email" name="user_email">
<br><br>
<label>Password</label>
<input type="password" name="user_password">
<br><br>
<label>Role</label>
<select name="user_role">
<option></option>
<option>Manager</option>
<option>Employee</option>
</select>
<br><br>
<label>salary</label>
<input type="text" name="user_salary">
<br><br>
<button>register</button>
</form>
</body>
</html>