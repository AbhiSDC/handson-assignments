<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdatePassword" method="post">
		<label>
			Current Password <input type="text" name="currpwd" required>
		</label>
		<br/><br/>
		<label>
			New Password <input type="text" name="newpwd" required>
		</label>
		<br/><br/>
		<input type="submit" value="Update">
	</form>
</body>
</html>