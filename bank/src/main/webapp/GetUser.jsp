<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<!DOCTYPE html>
<style>
th {
	margin: 20;
	width: 100px;
	text-align: left;
}

body {
	margin-top: 30px;
	margin-left: 20px;
	background-color: #f1f1f1;
	margin-left: 20px;
	font-family: Montserrat;
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful User Creation</title>
</head>
<body>
	<h1 align="center">XYZ Bank</h1>
	<h2>Successfully Created User</h2>
	<table>
		<tr>
			<th>Full Name:</th>
			<td>${USER.getUserName()}</td>
		</tr>
		<tr>
			<th>User Id:</th>
			<td>${USER.getUserId()}</td>
		</tr>
		<tr>
			<th>Email:</th>
			<td>${USER.getUserEmail()}</td>
		</tr>
		<tr>
			<th>Mobile:</th>
			<td>${USER.getUserPhone()}</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>A/C No:</th>
			<th>A/C Type:</th>
			<th>A/C Balance:</th>
		</tr>
		<c:forEach var="account" items="${USER.getAccounts()}">
			<tr>
				<td>${account.getAccountNumber()}</td>
				<td>${account.getAccountType()}</td>
				<td>${account.getAccountBalance()}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../index.jsp">Login</a>
</body>
</html>