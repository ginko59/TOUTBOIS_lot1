package model;

public abstract class Contact {
	public String enseigne;
	public String siret;
	public String civilite;
	public String nom;
	public String prenom ;
	public String fonction;
	public String email;
	public String tel;
	public int nbCommande;
	public Adresse adresse;
	public String getEnseigne() {
		return enseigne;
	}
	public String getSiret() {
		return siret;
	}
	public String getCivilite() {
		return civilite;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public String getEmail() {
		return email;
	}
	public String getTel() {
		return tel;
	}
	public int getNbCommande() {
		return nbCommande;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setEnseigne(String enseigne) {
		this.enseigne = enseigne;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setNbCommande(int nbCommande) {
		this.nbCommande = nbCommande;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	public Contact(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
			String email, String tel, int nbCommande, Adresse adresse) {
		super();
		this.enseigne = enseigne;
		this.siret = siret;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.email = email;
		this.tel = tel;
		this.nbCommande = nbCommande;
		this.adresse = adresse;
	}
	
	
	
	
	

}
