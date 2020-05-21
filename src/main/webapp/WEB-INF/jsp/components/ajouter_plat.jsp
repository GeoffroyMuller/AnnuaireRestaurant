<div style="padding-bottom: 0em;"
	class="list-group-item list-group-item-action mx-auto  bg-light w-50">
	<form action="restaurant" method="post">
		<div>

			<div class="row">
				<div class="col">
					<input type="text" class="form-control form-control-sm mb-3"
						placeholder="Nom" id="nom" name="nom"
						aria-describedby="basic-addon3">
				</div>
				<div class="col">
					<input type="text" class="form-control form-control-sm mb-3"
						placeholder="Type" id="type" name="type"
						aria-describedby="basic-addon3">
				</div>
				<div class="col">
					<input type="text" class="form-control form-control-sm mb-3"
						placeholder="Prix" id="prix" name="prix"
						aria-describedby="basic-addon3">
				</div>
			</div>

			<div class="row">
				<div class="col-8">
					<input type="text" class="form-control form-control-sm mb-3"
						placeholder="Déscription" id="description" name="description"
						aria-describedby="basic-addon3">
				</div>

				<div class="col-4">
					<div class="d-flex w-100 justify-content-between">
						<div></div>
						<button class="btn btn-outline-primary btn-sm my-2 my-sm-0"
							id="id" name="id" value="${ resto.getId() }" type="submit">Ajouter</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

