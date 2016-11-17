<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Student Details</title>
</head>
<body>
	<form action="/SpringMVCDemo/submitAdmissionForm.html" method="post">
		<p>
			Student Name : <input type="text" name="studentName">
		</p>
		<p>
			Student Hobby : <input type="text" name="hobby">
		</p>
		<input type="submit" value="Submit">
	</form>
</body>
</html>