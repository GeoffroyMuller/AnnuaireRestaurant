<%@ page pageEncoding="UTF-8"%>
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
		action="annuaire">
		<div class="form-inline mx-auto p-4 w-100">

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100 justify-content-between">
					<h3>Ajouter un resto</h3>
					<a href="/AnnuaireRestaurant/annuaire" class="text-decoration-none"><small>Retour</small></a>

				</div>

			</div>

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon3">Nom</span>
					</div>
					<input type="text" class="form-control" id="nom" name="nom" 
						aria-describedby="basic-addon3">
				</div>

			</div>

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon3">Adresse</span>
					</div>
					<input type="text" class="form-control" id="adresse" name="adresse" 
						aria-describedby="basic-addon3">
				</div>

			</div>

			<div class="d-flex w-100 justify-content-between">
				<div class="input-group mb-3 w-100">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon3">Spécialité</span>
					</div>
					<input type="text" class="form-control" id="specialite" name="specialite" 
						aria-describedby="basic-addon3">
				</div>

			</div>
			<div class="d-flex  justify-content-between">
				<div class="input-group mb-3 ">
					<a href="/AnnuaireRestaurant/ajouter" class="btn btn-outline-primary"type="submit">Enregistrer</a>
					&nbsp;&nbsp; 
					<a href="/AnnuaireRestaurant/ajouter" type="button"
						class="btn btn-outline-danger">Annuler</a>
				</div>

			</div>
		</div>




	</form>
	<br>
</body>
</html>