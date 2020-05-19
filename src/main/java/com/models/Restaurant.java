package com.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.factory.FactoryDao;

public class Restaurant {

	private int id; 
	private String nom;
	private String adresse;
	private String specialite;
	private List<Plat> listeDePlats;
	
	public Restaurant(String nom, String adresse, String specialite) {
		this.nom = nom;
		this.adresse = adresse;
		this.specialite = specialite;
		this.listeDePlats = null;
	}
	
	public Restaurant(int id, String nom, String adresse, String specialite) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.specialite = specialite;
	}
	
	public Restaurant(int id, String nom, String adresse, String specialite, List<Plat> listeDePlats) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.specialite = specialite;
		this.listeDePlats = listeDePlats;
	}

	
	
	public void addPlat(Plat plat) {
		try {
			FactoryDao.getInstance().getPlatDao().creat(plat);
			actialiserListeDePlats();
		} catch (SQLException e) {
			System.out.println("ajout plat en base echoué");
			e.printStackTrace();
		}
	}
	
	public void modifPlat(Plat plat) {
		try {
			FactoryDao.getInstance().getPlatDao().update(plat);
			actialiserListeDePlats();
		} catch (SQLException e) {
			System.out.println("modification plat en base echoué");
			e.printStackTrace();
		}
	}
	
	public void delPlatId(int i){
		try {
			FactoryDao.getInstance().getPlatDao().deleteById(i);;
			actialiserListeDePlats();
		} catch (SQLException e) {
			System.out.println("suppression plat en base echoué");
			e.printStackTrace();
		}
	}
	
	/**
	 * Mets a jours la liste de plat du resto 'this' par rapport a la base de données
	 */
	public void actialiserListeDePlats() {
		try {
			listeDePlats = FactoryDao.getInstance().getPlatDao().getListePlatByRestaurant(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Getter & Setter
	 */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Plat> getListeDePlats() {
		return listeDePlats;
	}

	public void setListeDePlats(List<Plat> listeDePlats) {
		this.listeDePlats = listeDePlats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
