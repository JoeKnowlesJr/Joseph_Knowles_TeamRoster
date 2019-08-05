<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Player</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<fieldset class='fieldset-auto-width'>
		<legend>Add a player to: <c:out value="${thisTeam.getName()}"/></legend>
		<c:set var="err" value="${err}"/>
		<c:if test="${err != null}">
			<p class="err"><c:out value="${err}"/></p>
		</c:if>
		<c:set var="id" value="${id}"/>
		<form action="/TeamRoster/AddPlayer?id=${id}" method="post">
			<label>First Name: 
				<input type="text" name="first_name" />
			</label>
			<label>Last Name: 
				<input type="text" name="last_name" />
			</label>
			<label>Age: 
				<input type="number" name="age" />
			</label>
			<button type="submit">Add</button><button type="button" onclick="window.history.back();">Cancel</button>
		</form>
	</fieldset>
</body>
</html>