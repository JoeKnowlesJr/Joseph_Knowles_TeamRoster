<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add a Team</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<fieldset class='fieldset-auto-width'>
		<legend>Add team</legend>
		<c:set var="err" value="${err}"/>
		<c:if test="${err != null}">
			<p><c:out value="${err}"/></p>
		</c:if>
		<form action="/TeamRoster/Teams" method="post">
			<label>Team Name: 
				<input type="text" name="name" />
			</label>
			<button type="submit">Add</button><button type="button" onclick="window.history.back();">Cancel</button>
		</form>
	</fieldset>
</body>
</html>