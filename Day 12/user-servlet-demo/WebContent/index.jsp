<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP Demo Project!</h1>
	<a href="ServletDemo">Demo</a>
	<form action="ServletDemo" method="get">
		<label>
			Username: <input type="text" name="un">
		</label>
<!-- 		<label>
			Phone No.: <input type="text" name="phone">
		</label> -->
		<input type="submit" value="Submit">
	</form>
</body>
</html>
