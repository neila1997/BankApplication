<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>XYZ Banking Application</title>
</head>
<style>
* {
	box-sizing: border-box;
}

body {
	margin-left: 20px;
	background-color: #f1f1f1;
	font-family: Montserrat;
}

.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}
</style>
<body>
	<div class="header">
		<h2>Welcome to the XYZ Banking Application</h2>
	</div>
	<div class="topnav">
		<a href="../CreateUser.jsp">Create a User</a> <a
			href="deposit/${USER.getUserId()}">Deposit</a> <a
			href="transfer/${USER.getUserId()}">Transfer</a> <a
			href="withdraw/${USER.getUserId()}">Withdraw</a> <a
			href="balance/${USER.getUserId()}">Balance</a>
	</div>
</body>
</html>