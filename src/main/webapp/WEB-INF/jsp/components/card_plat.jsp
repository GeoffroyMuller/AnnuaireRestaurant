<div
	class="list-group-item list-group-item-action mx-auto  bg-light w-50">
	<div class="d-flex w-100 justify-content-between">
		<p class="mb-1">${variable.getNom()}</p>
		<p class="mb-1">${variable.getPrix()} Euro</p>
	</div>

	<div class="d-flex w-100 justify-content-between">
		<small>${variable.getType()}</small>
		
		<div>
			<a href="/AnnuaireRestaurant/"
				class="text-decoration-none"><small>Supprimer</small></a>&nbsp;
		</div>
	</div>
	<div class="d-flex w-100 justify-content-between">
			<small>${variable.getDescription()}</small>
					<div>
			<a href="/AnnuaireRestaurant/"
				class="text-decoration-none"><small>Modifier</small></a>&nbsp;

		</div>

	</div>
</div>