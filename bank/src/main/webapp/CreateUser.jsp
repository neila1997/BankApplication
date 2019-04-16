<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<!DOCTYPE html>
<html>
<style>
input, textarea, select, button {
	width: 175px;
	margin: 0;
	-webkit-box-sizing: border-box; /* For legacy WebKit based browsers */
	-moz-box-sizing: border-box;
	/* For legacy (Firefox <29) Gecko based browsers */
	box-sizing: border-box;
}

form {
	margin-left: 20px;
	width: 390px;
	text-align: left;
}

body {
	margin-top: 30px;
	margin-left: 20px;
	background-color: #f1f1f1;
	margin-left: 20px;
	font-family: Montserrat;
}
th{
text-align:left;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Enter User Details</title>
</head>
<body>
	<h1 align="center">XYZ Bank</h1>
	<form action="user/createuser" method="post">
		<h2>Enter Account Details</h2>
		<table>
			<tr>
				<th>Enter Name:</th>
				<td><input type="text" name="userName" placeholder="Enter Name"
					autofocus required></td>
			</tr>
			<tr>
				<th>Enter User Name:</th>
				<td><input type="text" name="userId"
					placeholder="Enter User name" required></td>
			</tr>
			<tr>
				<th>Enter Password:</th>
				<td><input type="password" name="userPassword"
					placeholder="Enter Password" required></td>
			</tr>
			<tr>
				<th>Enter Email:</th>
				<td><input type="email" name="userEmail"
					placeholder="Enter Email" required></td>
			</tr>
			<tr>
				<th>Enter Address:</th>
				<td><input type="text" name="userAddress"
					placeholder="Enter Address" required></td>
			</tr>
			<tr>
				<th>Enter Date of Birth:</th>
				<td><input type="date" name="userDob" placeholder="Enter DOB"
					required></td>
			</tr>
			<tr>
				<th>Enter Phone Number:</th>
				<td><input type="text" name="userPhone"
					placeholder="Enter Number" required></td>
			</tr>
		</table>
		<h2 align="center">Select Account Type and Password</h2>
		<table>
			<tr>
				<th>Select Account Type:</th>
				<td><select name="accountType" required><option
							value="Savings">Savings</option>
						<option value="Current">Current</option></select></td>
			</tr>
			<tr>
				<th>Enter Transaction Password:</th>
				<td><input type="password" name="transactionPassword"
					placeholder="Enter Transaction Password" required></td>
			</tr>
			<tr align="center">
				<td colspan=2><input type="submit" name="Create User"></td>
			</tr>
		</table>
	</form>
</body>
</html>