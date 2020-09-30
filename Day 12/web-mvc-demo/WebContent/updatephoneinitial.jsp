<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Current Phone No.: ${userKey.phone}</p>
	<form action="UpdatePhoneNo" method="post">
		<label>
			New Phone No. <input type="text" name="newphone">
		</label>
		<input type="submit" value="Update">
	</form>
</body>
</html>