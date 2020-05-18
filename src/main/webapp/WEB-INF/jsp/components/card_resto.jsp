<div
	class="list-group-item list-group-item-action mx-auto  bg-light w-50">
	<div class="d-flex w-100 justify-content-between">
		<p class="mb-1">${variable.getNom()}</p>
		<a href="/AnnuaireRestaurant/restaurant?id=${variable.getId()}"
			class="btn btn-success btn-sm">Voir le Resto</a>
	</div>

	<div class="d-flex w-100 justify-content-between">
		<small>${variable.getSpecialite()}</small>
		<div>

			<a href="/AnnuaireRestaurant/modifier?id=${variable.getId()}"
				class="text-decoration-none"><small>Supprimer</small></a> &nbsp;

		</div>
	</div>
	<div class="d-flex w-100 justify-content-between">
		<small>${variable.getAdresse()}</small>
		<div>
			<a href="/AnnuaireRestaurant/modifier?id=${variable.getId()}"
				class="text-decoration-none"><small>Modifier</small></a> &nbsp;

		</div>

	</div>

</div>

