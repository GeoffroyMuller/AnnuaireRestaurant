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
	private Annuaire() {
		try {
			ListeDeResto = FactoryDao.getInstance().getRestaurantDao().getListeResto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	 * Ajoute un resto a l'annuaire (ajoute en memoire et actualise sa liste)
	 * @param resto
	 */
	public void addResto(Restaurant resto) {
		try {
			FactoryDao.getInstance().getRestaurantDao().creat(resto);
			actialiserListeDeResto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void actialiserListeDeResto() {
		try {
			ListeDeResto = FactoryDao.getInstance().getRestaurantDao().getListeResto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	 * Cherche un resto par son nom dans la liste de l'annuaire
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
