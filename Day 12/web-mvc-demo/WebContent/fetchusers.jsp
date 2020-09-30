<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<p> All registered users are:</p>
	<table class='table table-striped table-bordered'>
		<thead class='thead-dark'>
				<tr>
					<th>User ID</th>
					<th>Name</th>
					<th>Phone No.</th>
				</tr>
		</thead>
		<tbody class='table-info'>
			<core:forEach items="${usersList}" var="u">
				<tr>
					<td>${u.userId}</td>
					<td>${u.name}</td>
					<td> ${u.phone}</td>
				</tr>
			</core:forEach>
		</tbody>
	</table>
<!-- 	<a href="loginsuccess.jsp"> Back to Profile Page</a> -->
</body>
</html>