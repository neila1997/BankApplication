<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<!DOCTYPE html>
<html>
<style>
list {
	width: 300px;
}

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
<title>Deposit Money</title>
</head>
<body>
	<h1 align="center">XYZ Bank</h1>
	<h2 align="center">Transfer Money to Account</h2>
	<h3 align="left">${user.getUserName()}</h3>
	<form action="/user/transfermoney" method="post">
		<table border=1>
			<tr>
				<th>Select A/C</th>
				<td><select name="accountFrom" id="list">
						<c:forEach var="USER" items="${user.getAccounts()}">
							<option value="${USER.getAccountNumber()}">${USER.getAccountNumber()}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>Enter Beneficiary Account:</th>
				<td><input type="number" name="accountTo"></td>
			</tr>
			<tr>
				<th>Enter Amount:</th>
				<td><input type="number" name="transferAmount"></td>
			</tr>
			<tr align="center">
				<td colspan=2><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>