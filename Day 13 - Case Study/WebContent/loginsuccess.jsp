<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	<div style="display: flex;justify-content: space-between;">
		<h3 style="color: green;">Hello, ${userKey.name}</h3>
		<h3><a href="LogoutServlet">Logout</a></h3>
	</div>
	<hr/>
	<h3>Your Profile Details:</h3>
	<p>UserID: ${userKey.userId}<br />Name: ${userKey.name}<br />Password: ${userKey.password}<br />Phone No.: ${userKey.phone}</p>
	<hr/>
	<h3>Update Contact details:</h3>
	<h4>Add New Contact: <a href="addcontact.jsp">Add</a></h4>
	<h4>Access your Contacts: <a href="FetchContactsServlet">Contact List</a></h4>
	<hr />
	<h3>Edit Profile:</h3>
	<h4>Update Phone No.: <a href="updatephoneinitial.jsp">Phone No.</a></h4>
	<h4>Update Password: <a href="updatepwdinitial.jsp">Password</a></h4>
	<hr />
	<h3>Deleting Options:</h3>
	<h4>Delete User Profile: <a href="deleteuser.jsp">Phone No.</a></h4>
	<h4>Delete any Contact: <a href="deletecontact.jsp">Password</a></h4>
</body>
</html>