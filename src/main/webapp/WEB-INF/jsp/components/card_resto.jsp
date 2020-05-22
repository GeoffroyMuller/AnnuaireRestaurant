<div
	class="list-group-item list-group-item-action mx-auto  bg-light w-50">
	<div class="d-flex w-100 justify-content-between">
		<p class="mb-1">${resto.getNom()}</p>
		<a href="/AnnuaireRestaurant/restaurant?id=${resto.getId()}"
			class="btn btn-success btn-sm">Voir le Resto</a>
	</div>

	<div class="d-flex w-100 justify-content-between">
		<small>${resto.getSpecialite()}</small>
		<div>

			<form id="form${resto.getId()}" class="form" method="post" action="annuaire">
				<input class="form" type="search" style="visibility: hidden"
					id="supprimer" name="supprimer" value="${resto.getId()}" /> 
					<a href="javascript:{}"
					class="text-decoration-none"
					onclick="document.getElementById('form${resto.getId()}').submit(); return false;"><small>Supprimer</small></a>&nbsp;
			</form>

		</div>
	</div>
	<div class="d-flex w-100 justify-content-between">
		<small>${resto.getAdresse()}</small>
		<div>
			<a href="/AnnuaireRestaurant/modifier?id=${resto.getId()}&red=annuaire"
				class="text-decoration-none"><small>Modifier</small></a> &nbsp;

		</div>

	</div>

</div>

