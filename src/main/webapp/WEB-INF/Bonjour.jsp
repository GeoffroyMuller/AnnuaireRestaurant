<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	
	<p>
		Bonjour ${ empty name ? '' : name}
		dd ${ nom }
	</p>
	<c:if test="${ !empty nom }"><p><c:out value="heyyy ${ nom }"/></p></c:if>
	<form method="post" action="urltest">
		<label for="nom">Nom : </label>
		<input type="text" id="nom" name="nom"/>
		
		<input type="submit"/>
	</form>
</body>
</html>