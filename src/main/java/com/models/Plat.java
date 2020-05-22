package com.models;

public class Plat {

	private int id; 
	private int id_resto; 
	private String nom;
	private double prix;
	private String type;
	private String description;

	public Plat(int id_resto, String nom, double prix, String type, String description) {
		this.id_resto = id_resto;
		this.nom = nom;
		this.prix = prix;
		this.type = type;
		this.description = description;
	}
	
	public Plat(int id, int id_resto, String nom, double prix, String type, String description) {
		this.id = id;
		this.id_resto = id_resto;
		this.nom = nom;
		this.prix = prix;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_resto() {
		return id_resto;
	}

	public void setId_resto(int id_resto) {
		this.id_resto = id_resto;
	}
	
	
	
}
