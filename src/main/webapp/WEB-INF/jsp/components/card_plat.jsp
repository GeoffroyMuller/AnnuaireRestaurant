<div
	class="list-group-item list-group-item-action mx-auto  bg-light w-50">
	<div class="d-flex w-100 justify-content-between">
		<p class="mb-1">${plat.getNom()}</p>
		<p class="mb-1">${plat.getPrix()} Euro</p>
	</div>

	<div class="d-flex w-100 justify-content-between">
		<small>${plat.getType()}</small>

		<div >
			<form id="formplat${plat.getId()}" class="form" method="post"
				action="restaurant?id=${ resto.getId() }" >
				<input class="form" type="hidden" style="visibility: hidden"
					id="supprimer" name="supprimer" value="${plat.getId()}" /> 
					<a
					href="javascript:{}" class="text-decoration-none"
					onclick="document.getElementById('formplat${plat.getId()}').submit(); return false;"><small>Supprimer</small></a>&nbsp;
			</form>
			
		</div>
	</div>
	<div class="d-flex w-100 justify-content-between">
		<small>${plat.getDescription()}</small>
		<div>
			<a href="/AnnuaireRestaurant/modifierplat?id_plat=${plat.getId()}&id_resto=${resto.getId()}"
				class="text-decoration-none"><small>Modifier</small></a>&nbsp;

		</div>

	</div>
</div>