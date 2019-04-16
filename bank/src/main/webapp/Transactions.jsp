<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	margin-top: 30px;
	margin-left: 20px;
	background-color: #f1f1f1;
	margin-left: 20px;
	font-family: Montserrat;
}
</style>
<body>
	<h1 align="center">XYZ Bank</h1>
	<h2 align="center">Transactions</h2>
	<table border=1>
		<tr>
			<th>Account From</th>
			<th>Account To</th>
			<th>Transaction Amount</th>
		</tr>
		<c:forEach var="transaction" items="${TRANSACTIONS}">
			<tr>
				<td>${transaction.accountFrom}</td>
				<td>${transaction.accountTo}</td>
				<td>${transaction.transferAmount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>