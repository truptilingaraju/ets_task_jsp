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
<form action="task">
<label>Description</label>
<input type="text" name="user_description">
<br><br>
<label>Status</label>
<select name="user_status">
<option></option>
<option>In-Progress</option>
<option>Completed</option>
</select>
<br><br>
<button>register</button>
</form>
</body>
</html>