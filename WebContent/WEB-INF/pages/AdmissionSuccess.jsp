<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submitted Admission Detail</title>
</head>
<body>
	 <h1>${headerMessage}</h1>
	<table>
		<tr>
			<td>Student Name : ${objStudent.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby : ${objStudent.studentHobby}</td>
		</tr>
		<tr>
			<td>Student Mobile : ${objStudent.studentMobile}</td>
		</tr>
		<tr>
			<td>Student DOB : ${objStudent.studentDOB}</td>
		</tr>
		<tr>
			<td>Student Skills : ${objStudent.studentSkills}</td>
		</tr>
		<tr>
			<td>Student Address : </td>
			<td> 
				Country : ${objStudent.studentAddress.country}
				City : ${objStudent.studentAddress.city}
				Street : ${objStudent.studentAddress.street}
				PinCode : ${objStudent.studentAddress.pincode}
			</td>
		</tr>
	</table>
	<a href="/SpringMVCDemo/admissionForm.html">Back</a>
</body>
</html>