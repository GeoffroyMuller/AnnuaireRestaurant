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
	<div style="padding-bottom: 0em;"
		class="list-group-item list-group-item-action mx-auto  bg-light w-50">
		<form action="?id=${ id_resto }" method="post">
			<div>
				<div class="d-flex w-100 justify-content-between">
					<div class="input-group mb-3 w-100 justify-content-between">
						<p>Modifier le plat</p>
						<a href="javascript:history.go(-1)" class="text-decoration-none"><small>Retour</small></a>

					</div>

				</div>
				
				<div class="row">
					<div class="col">
						<input type="text" class="form-control form-control-sm mb-3"
							value="${ plat.getNom() }" id="nom" name="nom"
							aria-describedby="basic-addon3">
					</div>
					<div class="col">
						<input type="text" class="form-control form-control-sm mb-3"
							value="${ plat.getType() }" id="type" name="type"
							aria-describedby="basic-addon3">
					</div>
					<div class="col">
						<input type="text" class="form-control form-control-sm mb-3"
							value="${ plat.getPrix() }" id="prix" name="prix"
							aria-describedby="basic-addon3">
					</div>
				</div>

				<div class="row">
					<div class="col-8">
						<input type="text" class="form-control form-control-sm mb-3"
							value="${ plat.getDescription() }" id="description"
							name="description" aria-describedby="basic-addon3">
					</div>

					<div class="col-4">
						<div class="d-flex w-100 justify-content-between">
							<div></div>
							<input class="form" type="hidden" style="visibility: hidden"
								id="id_resto" name="id_resto" value="${ id_resto }" />

							<button class="btn btn-outline-primary btn-sm my-2 my-sm-0"
								id="enregistrer_plat" name="enregistrer_plat"
								value="${ plat.getId() }" type="submit">Enregistrer</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
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