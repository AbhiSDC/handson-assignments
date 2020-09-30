<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	<h3>Successfully Logged In!!</h3>
	<p>UserID: ${userKey.userId}<br />Name: ${userKey.name}<br />Password: ${userKey.password}<br />Phone No.: ${userKey.phone}</p>
	<hr />
	<h3>Update details:<br/></h3>
	<h4>For updating phone no.: <a href="updatephoneinitial.jsp">Phone No.</a></h4>
	<h4>For updating password: <a href="updatepwdinitial.jsp">Password</a></h4>
<!-- 	<h3><a href="FetchUsersServlet">FetchUsers</a></h3> -->
	<hr />
	<h3><a href="LogoutServlet">Logout</a></h3>
</body>
</html>