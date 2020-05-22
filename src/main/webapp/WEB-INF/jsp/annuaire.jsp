<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
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
	<form class="form-inline mx-auto p-4 w-50 " method="post"
		action="annuaire">
		<div class="form-inline mx-auto p-4 w-75" >
			<input class="form-control mx-auto p-1 w-100" type="search"
				placeholder="Chercher un resto nommé..." id="nom" name="nom" /> 
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input class="form-control mx-auto p-1 w-100" type="search"
				placeholder="Qui a pour spécialité..." id="specialite" name="specialite" />
		</div>
		<input class="btn btn-outline-primary my-2 my-sm-0" type="submit" name="button_chercher" value="Chercher" />
	</form>
	
	<c:forEach items="${liste}" var="resto">
		<%@ include file="components/card_resto.jsp"%>
	</c:forEach>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>

<%@ include file="components/footer.jsp"%>

</html>