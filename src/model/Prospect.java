package model;

import javafx.beans.property.StringProperty;

public class Prospect extends Contact {
	
public String dateVisite ;



public String getDateVisite() {
	return dateVisite;
}

public void setDateVisite(String dateVisite) {
	this.dateVisite = dateVisite;
}

public Prospect(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom, StringProperty prenom, StringProperty fonction,
		StringProperty email, StringProperty tel, int nbCommande, Adresse adresse) {
	super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
	// TODO Auto-generated constructor stub
}

public Prospect(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom, StringProperty prenom, StringProperty fonction,
		StringProperty email, StringProperty tel, int nbCommande, Adresse adresse, String dateVisite) {
	super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
	this.dateVisite = dateVisite;
}


}
