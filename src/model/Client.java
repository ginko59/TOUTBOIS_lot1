package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client extends Contact {

	public IntegerProperty identifiantC;
	public Representant representant= new Representant();
	public Adresse adresse= new Adresse() ;
	
	// public int identifiantR;

	public Client() {
			super();
		}
	
	public Client(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom,
			StringProperty prenom, StringProperty fonction, StringProperty email, StringProperty tel, int nbCommande,
			Adresse adresse) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		// TODO Auto-generated constructor stub
	}

	public Client(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom,
			StringProperty prenom, StringProperty fonction, StringProperty email, StringProperty tel, int nbCommande,
			Adresse adresse, SimpleIntegerProperty identifiantC, Representant representant) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		this.identifiantC = identifiantC;
		this.representant = representant;
	}

	public Client(String prenom, String nom, int identifiantC, String civilite, String fonction, String email, String tel, int nbCommande, String enseigne, String siret) {
	//, Adresse adresse
		this.prenom = new SimpleStringProperty(prenom);
		this.nom = new SimpleStringProperty(nom);
		this.identifiantC = new SimpleIntegerProperty(identifiantC);
		this.civilite = new SimpleStringProperty(civilite);
		this.fonction = new SimpleStringProperty (fonction);
		this.email= new SimpleStringProperty ( email);
		this.tel= new SimpleStringProperty (tel);
		this.nbCommande = new SimpleIntegerProperty(nbCommande);
		this.enseigne = new SimpleStringProperty(enseigne); 
		this.siret = new SimpleStringProperty(siret);
		
		
		
		
		
		
		// Some initial dummy data, just for convenient testing.
		this.adresse.voie = new SimpleStringProperty("some street");
		this.adresse.cp = new SimpleIntegerProperty(1234);
		this.adresse.ville = new SimpleStringProperty("some city");
		this.adresse.bp = new SimpleIntegerProperty(1111);
		this.adresse.complement= new SimpleStringProperty("ccc");
		this.adresse.nomVoie= new SimpleStringProperty("tennis");
		this.adresse.num = new SimpleIntegerProperty(11);
		this.adresse.pays = new SimpleStringProperty("pays");
		
		

	}

	public Integer getIdentifiantC() {
		return identifiantC.get();
	}

	public Representant getRepresentant() {
		return representant;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setIdentifiantC(Integer identifiantC) {
		this.identifiantC.set(identifiantC);
	}
	public IntegerProperty identifiantCProperty(){
		return identifiantC;
	}

	public void setRepresentant(Representant representant) {
		this.representant = representant;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
}
