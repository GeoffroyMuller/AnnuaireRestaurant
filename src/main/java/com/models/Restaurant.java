package com.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

	private int id; 
	private String nom;
	private String adresse;
	private String specialite;
	private List<Plat> listeDePlats;
	
	public Restaurant(int id, String nom, String adresse, String specialite, List<Plat> listeDePlats) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.specialite = specialite;
		this.listeDePlats = listeDePlats;
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
