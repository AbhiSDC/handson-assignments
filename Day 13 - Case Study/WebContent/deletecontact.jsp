<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Delete Contact Page</h3>
	<hr/>
	<h3>If you are sure, click on the link below:</h3><br/><br/>
	<form action="DeleteContactServlet">
		<label>
			Contact Id: <input type="text" name="id" required>
		</label>
		<input type="submit" value="Delete">
	</form>
	<br/><br/>
	<a href="DeleteContactServlet">Delete Contact</a>
</body>
</html>