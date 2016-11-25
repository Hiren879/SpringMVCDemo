<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to MVC Demo</title>
</head>
<body onload="document.f.j_username.focus();">
<h3>Login with User name and Password [Custom log in page]</h3>
	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
		<div>
			Log in failed.<br/> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<form name='f' action="<c:url value='/login' />" method='POST' >
		<table>
			<tr>
				<td>User Name : </td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>