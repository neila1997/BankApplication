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
	<h2 align="center">Deposit Money to Account</h2>
	<h3>${user.getUserName()}</h3>
	<form action="/user/depositmoney" method="post">
		<table border=1>
			<tr>
				<th>A/C No</th>
				<th>Amount</th>
			</tr>
			<tr>
				<td><select name="accountNumber" id="list">
						<c:forEach var="USER" items="${user.getAccounts()}">
							<option value="${USER.getAccountNumber()}">${USER.getAccountNumber()}</option>
						</c:forEach>
				</select></td>
				<td><input type="number" name="transferAmount"></td>
			</tr>
			<tr align="center">
				<td colspan=3><input type="submit" name="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>