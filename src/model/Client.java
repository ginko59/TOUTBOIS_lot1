package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client extends Contact {

	public IntegerProperty identifiantC;
	public Representant representant ;
	
	Adresse adresse= new Adresse();
	
	//public int identifiantR;
	
	
	
	public Integer getIdentifiantC() {
		return identifiantC.get();
	}
	
	public IntegerProperty identifiantCProperty() {
		return identifiantC;
	}
	public void setIdentifiantC(Integer identifiantC){
		this.identifiantC.set(identifiantC);
	}
	




	public Representant getRepresentant() {
		return representant;
	}






	public Adresse getAdresse() {
		return adresse;
	}






	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}






	public int getIdentifiantR() {
		return getIdentifiantR();
	}



	public void setRepresentant(Representant representant) {
		this.representant = representant;
	}
	


	public Client(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom, StringProperty prenom, StringProperty fonction,
			StringProperty email, StringProperty tel, int nbCommande, Adresse adresse) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		// TODO Auto-generated constructor stub
	}


	public Client(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom, StringProperty prenom, StringProperty fonction,
			StringProperty email, StringProperty tel, int nbCommande, Adresse adresse, SimpleIntegerProperty identifiantC, Representant representant) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		this.identifiantC = identifiantC;
		this.representant = representant;
	}
	
	public Client(String prenom, String nom) {
        this.prenom = new SimpleStringProperty(prenom);
        this.nom = new SimpleStringProperty(nom);

        // Some initial dummy data, just for convenient testing.
        adresse.voie = new SimpleStringProperty("some street");
        adresse.cp = new SimpleIntegerProperty(1234);
        adresse.ville = new SimpleStringProperty("some city");
       
    }


}
