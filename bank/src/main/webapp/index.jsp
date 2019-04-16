<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<html>
<style>
body {
	margin-top: 30px;
	margin-left: 20px;
	background-color: #f1f1f1;
	margin-left: 20px;
	font-family: Montserrat;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Banking Application</title>
</head>
<body>
	<p id="top">
	<h2>Welcome to the XYZ Banking Application</h2>
	</p>
	<br>
	<h3>Enter your credentials</h3>
	<table>
		<form action="user/checkuser" method="post">
			<tr>
				<td>Enter User Id</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>Enter User Password</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
			<tr colspan=2>
				<td><input type="submit" name="Submit"></td>
			</tr>
		</form>
	</table>
	<h4>New User?</h4>
	<a href="../CreateUser.jsp">Create an Account with us.</a>
</body>
</html>