package model;

import javafx.beans.property.StringProperty;

public abstract class Contact {
	public StringProperty enseigne;
	public StringProperty siret;
	public StringProperty civilite;
	public StringProperty nom;
	public StringProperty prenom ;
	public StringProperty fonction;
	public StringProperty email;
	public StringProperty tel;
	public int nbCommande;
	public Adresse adresse;
	
	
	public String getEnseigne() {
		return enseigne.get();
	}
	public String getSiret() {
		return siret.get();
	}
	public String getCivilite() {
		return civilite.get();
	}
	public String getNom() {
		return nom.get();
	}
	public String getPrenom() {
		return prenom.get();
	}
	public String getFonction() {
		return fonction.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getTel() {
		return tel.get();
	}
	public int getNbCommande() {
		return nbCommande;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	
	
	public void setEnseigne(String enseigne) {
		this.enseigne.set(enseigne);
	}
	public void setSiret(String siret) {
		this.siret.set(siret);
	}
	public void setCivilite(String civilite) {
		this.civilite.set(civilite);
	}
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
	public void setFonction(String fonction) {
		this.fonction.set(fonction);
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public void setTel(String tel) {
		this.tel.set(tel);
	}
	public void setNbCommande(int nbCommande) {
		this.nbCommande = nbCommande;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	public Contact(StringProperty enseigne2, StringProperty siret2, StringProperty civilite2, StringProperty nom2, StringProperty prenom2, StringProperty fonction2,
			StringProperty email2, StringProperty tel2, int nbCommande, Adresse adresse) {		super();
		this.enseigne = enseigne2;
		this.siret = siret2;
		this.civilite = civilite2;
		this.nom = nom2;
		this.prenom = prenom2;
		this.fonction = fonction2;
		this.email = email2;
		this.tel = tel2;
		this.nbCommande = nbCommande;
		this.adresse = adresse;
	}
	
	public Contact() {		
		super();
		
	}
	
	
	
	
	

}
