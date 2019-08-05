<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roster</title>
</head>
<body>
	<fieldset class='fieldset-auto-width'>
		<c:set var="team" value="${thisTeam}"/>
		<c:set var="id" value="${id}"/>
		<legend><c:out value="${team.getName()}"/></legend>
		<div class="tags">
			<a href="/TeamRoster/Home"><img src='back-arrow.png' /></a>
			<a href="/TeamRoster/Players?id=${id}">Add ${team.getName()}</a>
		</div>
		<table>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th> </th>
			</tr>
			<c:set var="players" value="${team.getPlayers()}"/>
			<c:forEach items="${players}" var="player" varStatus="loop">
				<tr>
   					<td>${player.getFirst()} ${player.getLast()}</td>
   					<td class='center_td'>${player.getAge()}</td>
   					<td> 
   						<a onclick="getCategoryIndex(${loop.index})" href="/TeamRoster/DeletePlayer?id=${loop.index}&teamId=${id}">Delete</a>
   					</td>
   				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>