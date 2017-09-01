package model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Prospect extends Contact {
	
protected ObjectProperty<LocalDate> dateVisite;
private Representant representant= new Representant();

public Prospect() {
	
	super();

	this.adresse = new Adresse();
	//this.representant = new Representant();
	
	this.dateVisite  = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 1, 11));

}


public LocalDate getDateVisite() {
	return dateVisite.get();
}

public ObjectProperty<LocalDate> birthdayProperty() {
    return dateVisite;
}

@XmlJavaTypeAdapter(LocalDateAdapter.class)
public LocalDate getBirthday() {
    return dateVisite.get();
}

public void setDateVisite(LocalDate dateVisite) {
	this.dateVisite.set(dateVisite);
}

public Representant getRepresentant() {
	return representant;
}

public void setRepresentant(Representant representant) {
	this.representant = representant;
}

public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}


public Prospect(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom,
		StringProperty prenom, StringProperty fonction, StringProperty email, StringProperty tel, int nbCommande,
		Adresse adresse) {
	super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
	// TODO Auto-generated constructor stub
}


public Prospect(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom,
		StringProperty prenom, StringProperty fonction, StringProperty email, StringProperty tel, int nbCommande,
		Adresse adresse, ObjectProperty<LocalDate> dateVisite, Representant representant) {
	super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
	this.dateVisite = dateVisite;
	this.representant = representant;
}

public Prospect(String prenom, String nom, String civilite, String fonction, String email, String tel, int nbCommande, String enseigne, String siret) {
	
	
	this.prenom = new SimpleStringProperty(prenom);
	this.nom = new SimpleStringProperty(nom);
	this.dateVisite  = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 1, 11));
	this.civilite = new SimpleStringProperty(civilite);
	this.fonction = new SimpleStringProperty (fonction);
	this.email= new SimpleStringProperty ( email);
	this.tel= new SimpleStringProperty (tel);
	this.nbCommande = new SimpleIntegerProperty(0);
	this.enseigne = new SimpleStringProperty(enseigne); 
	this.siret = new SimpleStringProperty(siret);
	this.representant.identifiantR =new SimpleIntegerProperty(representant.getIdentifiantR());
	
	
	
	
	
	// Some initial dummy data, just for convenient testing.
	this.getAdresse().voie = new SimpleStringProperty("voie");
	this.getAdresse().cp = new SimpleIntegerProperty(1234);
	this.getAdresse().ville = new SimpleStringProperty("some city");
	this.getAdresse().bp = new SimpleIntegerProperty(1111);
	this.getAdresse().complement= new SimpleStringProperty("ccc");
	this.getAdresse().nomVoie= new SimpleStringProperty("tennis");
	this.getAdresse().num = new SimpleIntegerProperty(11);
	this.getAdresse().pays = new SimpleStringProperty("pays");
	
	

}
}



