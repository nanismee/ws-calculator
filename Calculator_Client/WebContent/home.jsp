<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Calculator</title>
</head>
<body>
<h1>IWS Assigment 1</h1>
	<form action="MyServlet" method="get">
		<table>
			<tr>
				<td>First Number:</td>
				<td><input type="text" name="firstNum" value="${fs}" /></td>
			</tr>
			<tr>
				<td>Second Number:</td>
				<td><input type="text" name="secondNum" value="${sc}" /></td>
			</tr>
			<tr>
				<td>Choose Operator:</td>
				<td><select name="operator">
						<option>+</option>
						<option>-</option>
						<option>*</option>
						<option>/</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Compute</button>
				</td>
			</tr>
			<tr>
				<td>Result:</td>
				<td><input type="text" value=${rs}></td>
			</tr>
		</table>
	</form>
</body>
</html>