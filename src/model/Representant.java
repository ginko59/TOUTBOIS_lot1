package model;

import javafx.beans.property.IntegerProperty;

public class Representant extends Contact {
	public IntegerProperty identifiantR;
	public float tauxCommission;
	public float salaire;
	
	public IntegerProperty getIdentifiantR() {
		return identifiantR;
	}
	public float getTauxCommission() {
		return tauxCommission;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setIdentifiantR(int identifiantR) {
		this.identifiantR.set(identifiantR);
	}
	public void setTauxCommission(float tauxCommission) {
		this.tauxCommission = tauxCommission;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public Representant(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
			String email, String tel, int nbCommande, Adresse adresse, int identifiantR, float tauxCommission,
			float salaire) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		this.identifiantR.set(identifiantR);;
		this.tauxCommission = tauxCommission;
		this.salaire = salaire;
	}
	public Representant(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
			String email, String tel, int nbCommande, Adresse adresse) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		// TODO Auto-generated constructor stub
	}
	 
	

}
