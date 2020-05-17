package com.models;

public class Plat {

	private String nom;
	private double prix;
	private String typeDePlat;
	private String description;

	public Plat(String nom, double prix, String typeDePlat, String description) {
		this.nom = nom;
		this.prix = prix;
		this.typeDePlat = typeDePlat;
		this.description = description;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getTypeDePlat() {
		return typeDePlat;
	}

	public void setTypeDePlat(String typeDePlat) {
		this.typeDePlat = typeDePlat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
