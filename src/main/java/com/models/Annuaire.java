package com.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import com.factory.FactoryDao;

/**
 * Singleton
 * @author Geoff
 */
public class Annuaire {

	private static Annuaire instance;
	private List<Restaurant> ListeDeResto;

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
		}
		return instance;
	}

	/**
	 * Ajoute un resto a l'annuaire (ajoute en base et actualise sa liste)
	 * @param resto
	 */
	public void addResto(Restaurant resto) {
		try {
			FactoryDao.getInstance().getRestaurantDao().creat(resto);
			actialiserListeDeResto();
		} catch (SQLException e) {
			System.out.println("ajout resto en base echoué");
			e.printStackTrace();
		}
	}
	
	/**
	 * modifie un resto par son id dans l'annuaire (modifie en base et actualise sa liste)
	 * @param resto
	 */
	public void modifResto(Restaurant resto) {
		try {
			FactoryDao.getInstance().getRestaurantDao().update(resto);
			actialiserListeDeResto();
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
			actialiserListeDeResto();
		} catch (SQLException e) {
			System.out.println("suppression resto en base echoué");
			e.printStackTrace();
		}
	}
	
	/**
	 * Mets a jours la liste de resto de l'annuaire par rapport a la base de données
	 */
	public void actialiserListeDeResto() {
		try {
			ListeDeResto = FactoryDao.getInstance().getRestaurantDao().getListeResto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cherche les resto par leurs nom dans la liste de l'annuaire
	 * @return liste vide si aucun resto ne correspond
	 */
	public List<Restaurant> getRestoByNomEtSpe (String nom, String specialite){
		return getRestoBySpecialite(specialite, getRestoByNom(nom));

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
		return listeRestoRes;
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

}
