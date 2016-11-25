<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdmissionForm</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h2>Welcome ${userName}. Please fill up following details</h2>
	<form:errors path="objStudent.*"/>
	
	<form action="/SpringMVCDemo/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName"/> </td> <td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student Hobby :</td> <td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td>Student Mobile Number : </td> <td><input type="text" name="studentMobile"/> </td>
			</tr>
			<tr>
				<td>Student DOB : </td><td> <input type="text" name="studentDOB" /> </td>
				<td>Sample : 2012--12--12</td>
			</tr>
			<tr>
				<td>Student Skills Set : </td>
				<td>
					<select name="studentSkills" multiple="multiple">
						<option value="Core Java">Core Java</option>
						<option value="Spring MVC">Spring MVC</option>
						<option value="Spring Boot">Spring Boot</option>
						<option value="Spring Core">Spring Core</option>
					</select>
				</td>
			</tr>
		</table>
		<table>
			<tr><td>Studemt's Address</td></tr>
			<tr>
				<td>Country : <input type="text" name="studentAddress.country"></td>
				<td>City : <input type="text" name="studentAddress.city"></td>
				<td>Street :  <input type="text" name="studentAddress.street"></td>
				<td>PinCode :  <input type="text" name="studentAddress.pincode"></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
	<a href="/SpringMVCDemo/logout"> Logout</a>
</body>
</html>