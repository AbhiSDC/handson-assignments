<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Current Contact No.: ${newContact.contactNo}</p>
	<form action="UpdateContactNameServlet" method="post">
		<label>
			Contact ID: <input type="text" name="id" required>
		</label>
		<br/><br/>
		<label>
			New Name: <input type="number" name="name" required>
		</label>
		<br/><br/>
		<input type="submit" value="Update">
	</form>
</body>
</html>