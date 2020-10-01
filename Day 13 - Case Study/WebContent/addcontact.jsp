<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
	<h3>Adding New Contact</h3><hr/>
	<form action="AddContactServlet" method="post">
		<label>
			Name: <input type="text" name="name">		
		</label>
		<br/><br/>
		<label>
			Contact No. <input type="number" name="contact">
		</label>
		<br/><br/>
		<input type="submit" value="Add">
	</form>
</body>
</html>