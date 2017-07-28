package model;

public class Prospect extends Contact {
	
public String dateVisite ;



public String getDateVisite() {
	return dateVisite;
}

public void setDateVisite(String dateVisite) {
	this.dateVisite = dateVisite;
}

public Prospect(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
		String email, String tel, int nbCommande, Adresse adresse) {
	super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
	// TODO Auto-generated constructor stub
}

public Prospect(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
		String email, String tel, int nbCommande, Adresse adresse, String dateVisite) {
	super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
	this.dateVisite = dateVisite;
}


}
