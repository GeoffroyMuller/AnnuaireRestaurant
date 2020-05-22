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
	<br>
	<div class="mx-auto w-50">
		<div class="d-flex w-100 justify-content-between">
			<h4>${ resto.getNom() }
				<a
					href="/AnnuaireRestaurant/modifier?id=${resto.getId()}&red=restaurant"
					class="badge badge-primary">Modifier</a>
			</h4>

		</div>
		<div class="d-flex w-100 justify-content-between">
			<small>Spécialité : ${ resto.getSpecialite() }</small> <a
				href="/AnnuaireRestaurant/annuaire" class="text-decoration-none"><small>Retour</small></a>

		</div>
		<div class="d-flex w-100 justify-content-between">
			<small>Adresse : ${ resto.getAdresse() }</small>
		</div>
	</div>
	<br>

	<%@ include file="components/ajouter_plat.jsp"%>
	<br>
	<c:forEach items="${liste_plat}" var="plat">
		<%@ include file="components/card_plat.jsp"%>
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