<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Team Rosters</title>
	</head>
	<body>
		<fieldset class='fieldset-auto-width'>
			<legend>Teams</legend>
			<a href="/TeamRoster/teams.jsp">Add Team</a>
			<table>
				<tr>
					<th>Name</th>
					<th>Size</th>
					<th> </th>
				</tr>
				<c:forEach items="${teams}" var="team" varStatus="loop">
				<tr>
   					<td>${team.getName()}</td>
   					<td>${team.getPlayers().size()}</td>
   					<td>
   						<a onclick="getCategoryIndex(${loop.index})" href="ShowRoster?id=${loop.index}">Details</a> 
   						<a onclick="getCategoryIndex(${loop.index})" href="/TeamRoster/DeleteTeam?id=${loop.index}">Delete</a>
   					</td>
   				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>