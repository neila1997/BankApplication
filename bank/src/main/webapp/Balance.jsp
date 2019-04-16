<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<!DOCTYPE html>
<html>
<style>
body {
	margin-left: 35px;
	background-color: #f1f1f1;
	font-family: Montserrat;
}

.table {
	margin-top: 50px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Account Balance</title>
</head>
<body>
	<h1 align="center">XYZ Bank</h1>
	<h2 align="center">Account Balance</h2>
	<table border=1 class="table">
		<tr>
			<th>A/C Number</th>
			<th>A/C Balance</th>
		</tr>
		<c:forEach var="user" items="${USER.getAccounts()}">
			<tr>
				<td>${user.getAccountNumber()}</td>
				<td>${user.getAccountBalance()}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="account">
		<h2>Retrieve Last Transactions</h2>
		<h3>Select Account</h3>
		<form action="/user/transactions" method="post">
			<select name=accountNumber>Account Number:
				<c:forEach var="user" items="${USER.getAccounts()}">
					<option value="${user.getAccountNumber()}">${user.getAccountNumber()}</option>
				</c:forEach>
			</select> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>