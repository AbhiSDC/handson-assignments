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
	<form action="UpdateContactPhoneServlet" method="post">
		<label>
			Contact ID: <input type="text" name="id">
		</label>
		<br/><br/>
		<label>
			New No.: <input type="number" name="contact">
		</label>
		<br/><br/>
		<input type="submit" value="Update">
	</form>
</body>
</html>