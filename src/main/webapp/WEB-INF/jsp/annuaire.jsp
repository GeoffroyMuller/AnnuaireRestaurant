<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<%@ include file="components/entete.jsp"%>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form class="form-inline mx-auto p-4 w-50" method="post"
		action="annuaire">
		<input class="form-control mx-auto p-1 w-75" type="search"
			placeholder="Chercher un resto..." id="nom" name="nom" />
		<button type="button" class="btn btn-light">Chercher</button>
	</form>
	<c:forEach items="${liste}" var="variable">
		<%@ include file="components/card_resto.jsp"%>
	</c:forEach>
</body>
</html>