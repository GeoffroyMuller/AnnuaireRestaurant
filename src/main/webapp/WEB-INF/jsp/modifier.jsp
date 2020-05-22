<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form class="form-inline mx-auto p-4 w-50 " method="post"
		action="modifier?id=${ resto.getId() }">
		<div class="form-inline mx-auto p-4 w-100">

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100 justify-content-between">
					<h3>Modifier un resto</h3>
					<a href="javascript:history.go(-1)" class="text-decoration-none"><small>Retour</small></a>

				</div>

			</div>

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon3">Nom</span>
					</div>
					<input type="text" class="form-control" id="nom" name="nom" value="${ resto.getNom() }"
						aria-describedby="basic-addon3">
				</div>

			</div>

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon3">Adresse</span>
					</div>
					<input type="text" class="form-control" id="adresse" name="adresse" value="${ resto.getAdresse() }"
						aria-describedby="basic-addon3">
				</div>

			</div>

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon3">Spécialité</span>
					</div>
					<input type="text" class="form-control" id="specialite" name="specialite" value="${ resto.getSpecialite() }"
						aria-describedby="basic-addon3">
				</div>

			</div>
			<div class="d-flex  justify-content-between">
				<div class="input-group mb-3 ">
				<input class="form" type="hidden" style="visibility: hidden"
					id="red" name="red" value="${ red }" /> 
					<button class="btn btn-outline-primary my-2 my-sm-0" name="id" value="${ resto.getId() }" type="submit">Enregistrer</button>
				</div>

			</div>
		</div>
	</form>
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