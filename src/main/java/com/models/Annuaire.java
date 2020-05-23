package com.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.FactoryDao;

/**
 * Singleton
 * @author Geoff
 */
public class Annuaire {

	private static Annuaire instance;
	private List<Restaurant> ListeDeResto;
	private List<Restaurant> ListeDeRestoCourante;

	/**
	 * Constructeur privé
	 */
	private Annuaire() { }

	/**
	 * Recuppere la seul instance d'Annuaire
	 */
	public static Annuaire getInstance() {
		if(instance == null) {
			instance = new Annuaire();
			instance.actualiserListeDeResto();

		}
		return instance;
	}

	/**
	 * Ajoute un resto a l'annuaire (ajoute en base et actualise sa liste)
	 * @param resto
	 */
	public void addResto(Restaurant resto) throws IllegalArgumentException{
		try {
			if(resto.getNom().isEmpty()||resto.getAdresse().isEmpty()) {
				throw new IllegalArgumentException("Les champs doivent être complétés");
			}
			RestoIsExist(resto);
			FactoryDao.getInstance().getRestaurantDao().creat(resto);
			actualiserListeDeResto();
		} catch (SQLException e) {
			System.out.println("ajout resto en base echoué");
			e.printStackTrace();
		}
	}

	/**
	 * modifie un resto par son id dans l'annuaire (modifie en base et actualise sa liste)
	 * @param resto
	 */
	public void modifResto(Restaurant resto) throws IllegalArgumentException{
		try {
			if(resto.getNom().isEmpty()||resto.getAdresse().isEmpty()) {
				throw new IllegalArgumentException("Les champs doivent être complétés");
			}
			RestoIsExistWithId(resto);
			FactoryDao.getInstance().getRestaurantDao().update(resto);
			actualiserListeDeResto();
		} catch (SQLException e) {
			System.out.println("modification resto en base echoué");
			e.printStackTrace();
		}
	}

	/**
	 * Supprime un resto par son id dans l'annuaire (suppression en base et actualise sa liste)
	 * @param i
	 */
	public void delRestoId(int i) {
		try {
			FactoryDao.getInstance().getRestaurantDao().deleteById(i);
			actualiserListeDeResto();
		} catch (SQLException e) {
			System.out.println("suppression resto en base echoué");
			e.printStackTrace();
		}
	}

	/**
	 * Mets a jours la liste de resto de l'annuaire par rapport a la base de données
	 */
	public void actualiserListeDeResto() {
		try {
			ListeDeResto = FactoryDao.getInstance().getRestaurantDao().getListeResto();
			instance.ListeDeRestoCourante = instance.ListeDeResto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cherche les resto par leurs nom dans la liste de l'annuaire
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoByNomEtSpe (String nom, String specialite){
		List<Restaurant> listeRestoRes = getRestoBySpecialite(specialite, getRestoByNom(nom));
		ListeDeRestoCourante = listeRestoRes;
		return listeRestoRes;

	}

	/**
	 * Cherche un resto par son id dans la liste de l'annuaire
	 * @return null si aucun resto ne correspond
	 */
	public Restaurant getRestoById(int id) {
		for (Restaurant restaurant : ListeDeResto) {
			if(restaurant.getId()==id) {
				return restaurant;
			}
		}
		return null;
	}

	/**
	 * Cherche les resto par leurs nom dans la liste de l'annuaire
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoByNom (String nom){
		ArrayList<Restaurant> listeRestoRes = new ArrayList<Restaurant>();
		nom = nom.toLowerCase();
		for (Restaurant restaurant : ListeDeResto) {
			if(restaurant.getNom().toLowerCase().contains(nom)) {
				listeRestoRes.add(restaurant);
			}
		}
		ListeDeRestoCourante = listeRestoRes;
		return listeRestoRes;
	}

	/**
	 * Cherche les resto par leurs adresse dans la liste de l'annuaire
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoByAdresse (String adresse){
		ArrayList<Restaurant> listeRestoRes = new ArrayList<Restaurant>();
		adresse = adresse.toLowerCase();
		for (Restaurant restaurant : ListeDeResto) {
			if(restaurant.getAdresse().toLowerCase().contains(adresse)) {
				listeRestoRes.add(restaurant);
			}
		}
		ListeDeRestoCourante = listeRestoRes;
		return listeRestoRes;
	}

	/**
	 * Cherche les resto par leurs nom dans la liste de l'annuaire sensible a la casse
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoByNomSensible (String nom){
		ArrayList<Restaurant> listeRestoRes = new ArrayList<Restaurant>();
		nom = nom.toLowerCase();
		for (Restaurant restaurant : ListeDeResto) {
			if(restaurant.getNom().toLowerCase().equals(nom)) {
				listeRestoRes.add(restaurant);
			}
		}
		return listeRestoRes;
	}

	/**
	 * Cherche les resto par leurs adresse dans la liste de l'annuaire sensible a la casse
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoByAdresseSensible (String adresse){
		ArrayList<Restaurant> listeRestoRes = new ArrayList<Restaurant>();
		adresse = adresse.toLowerCase();
		for (Restaurant restaurant : ListeDeResto) {
			if(restaurant.getAdresse().toLowerCase().equals(adresse)) {
				listeRestoRes.add(restaurant);
			}
		}
		return listeRestoRes;
	}

	/**
	 * Cherche les resto par leurs specialites dans la liste donné en parametre
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoBySpecialite (String specialite, List<Restaurant> listeResto){
		List<Restaurant> listeRestoRes = new ArrayList<Restaurant>();
		specialite = specialite.toLowerCase();
		for (Restaurant restaurant : listeResto) {
			if(restaurant.getSpecialite().toLowerCase().contains(specialite)) {
				listeRestoRes.add(restaurant);

			}
		}
		ListeDeRestoCourante = listeRestoRes;
		return listeRestoRes;
	}

	/**
	 * Retourne un IllegalArgumentException si le nom ou l'adresse du resto est deja existant en excluant l'id du resto
	 * @throws IllegalArgumentException
	 */
	private void RestoIsExistWithId(Restaurant resto) throws IllegalArgumentException{
		actualiserListeDeResto();
		List<Restaurant> listnom = getRestoByNomSensible(resto.getNom());
		List<Restaurant> listadresse = getRestoByAdresseSensible(resto.getAdresse());
		System.out.println("id"+resto.getId());
		System.out.println("liste"+listnom);
		if(!listnom.isEmpty()) {
			if(listnom.get(0) != null) {
				if(listnom.get(0).getId()!=resto.getId()) {
					actualiserListeDeResto();
					throw new IllegalArgumentException("Erreur : Le nom du resto est deja existant");

				}
			}
		}
		if(!listadresse.isEmpty()) {
			if(listadresse.get(0) != null) {
				if(listadresse.get(0).getId()!=resto.getId()) {
					actualiserListeDeResto();
					throw new IllegalArgumentException("Erreur : L'adresse du resto est deja existante");
				}
			}
		}
	}

	/**
	 * Retourne un IllegalArgumentException si le nom ou l'adresse du resto est deja existante
	 * @throws IllegalArgumentException
	 */
	private void RestoIsExist(Restaurant resto) throws IllegalArgumentException{
		actualiserListeDeResto();
		if(!getRestoByNomSensible(resto.getNom()).isEmpty()) {
			actualiserListeDeResto();
			throw new IllegalArgumentException("Erreur : Le nom du resto est deja existant");
		}
		if(!getRestoByAdresseSensible(resto.getAdresse()).isEmpty()) {
			actualiserListeDeResto();
			throw new IllegalArgumentException("Erreur : L'adresse du resto est deja existante");
		}
	}


	public List<Restaurant> getRestoSpe (String specialite){
		return null;
	}

	public List<Restaurant> getRestoNom (List<Restaurant> ListeDeResto, String nom){
		return null;
	}

	public List<Restaurant> getRestoSpe (List<Restaurant> ListeDeResto, String specialite){
		return null;
	}

	public List<Restaurant> getListeDeResto() {
		return ListeDeResto;
	}

	public void setListeDeResto(List<Restaurant> listeDeResto) {
		ListeDeResto = listeDeResto;
	}

	public List<Restaurant> getListeDeRestoCourante() {
		return ListeDeRestoCourante;
	}

	public void setListeDeRestoCourante(List<Restaurant> listeDeRestoCourante) {
		ListeDeRestoCourante = listeDeRestoCourante;
	}



}
