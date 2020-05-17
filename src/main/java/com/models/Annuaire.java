package com.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.FactoryDao;

public class Annuaire {

	private static Annuaire instance;
	private List<Restaurant> ListeDeResto;
	
	private Annuaire() {
		try {
			ListeDeResto = FactoryDao.getInstance()
					.getRestaurantDao().getListeResto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Annuaire getInstance() {
		if(instance == null) {
			instance = new Annuaire();
		}
		return instance;
	}
	
	public Restaurant getRestaurantById(int id) {
		for (Restaurant restaurant : ListeDeResto) {
			if(restaurant.getId()==id) {
				return restaurant;
			}
		}
		return null;
	}
	
	public List<Restaurant> getRestoNom (String nom){
		return null;
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
