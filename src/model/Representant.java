package model;


import javax.xml.bind.annotation.XmlTransient;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Representant extends Contact {
	private static int compteurR = 0; 
	protected IntegerProperty identifiantR;
	protected FloatProperty tauxCommission;
	protected FloatProperty salaire;
	
	
	public Representant() {
		super();
		compteurR++;
		this.adresse = new Adresse();
		this.identifiantR =new SimpleIntegerProperty(compteurR);
		this.salaire = new SimpleFloatProperty(0);
		this.tauxCommission= new SimpleFloatProperty(0);
		
	}
	
	public Integer getIdentifiantR() {
		return identifiantR.get();
	}
	
	public Float getTauxCommission() {
		return tauxCommission.get();
	}
	
	public Float getSalaire() {
		return salaire.get();
	}
	public void setIdentifiantR(Integer identifiantR) {
		this.identifiantR.set(identifiantR);
	}
	public void setTauxCommission(float tauxCommission) {
		this.tauxCommission.set(tauxCommission);
	}
	public void setSalaire(float salaire) {
		this.salaire.set(salaire);
	}
	
	public Adresse getAdresse() {
		return adresse;
	}	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public IntegerProperty identifiantRProperty(){
		return identifiantR;
	}
	public FloatProperty tauxCommissionProperty(){
		return tauxCommission;
	}
	public FloatProperty salaireProperty(){
		return salaire;
	}
	
	
	public Representant(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom, StringProperty prenom, StringProperty fonction,
			StringProperty email, StringProperty tel, int nbCommande, Adresse adresse, int identifiantR, float tauxCommission,
			float salaire) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		this.identifiantR.set(identifiantR);;
		this.tauxCommission.set(tauxCommission);
		this.salaire.set(salaire);
	}
	
	public Representant(StringProperty enseigne, StringProperty siret, StringProperty civilite, StringProperty nom, StringProperty prenom, StringProperty fonction,
			StringProperty email, StringProperty tel, int nbCommande, Adresse adresse) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		
	}

	
	
	
	public Representant(String prenom, String nom, String civilite, String fonction, String email, String tel, String enseigne, String siret) {
				
			this.enseigne = new SimpleStringProperty(enseigne); 
			this.siret = new SimpleStringProperty(siret);
			
											
			// Some initial dummy data, just for convenient testing.
			
			compteurR++;
			this.prenom = new SimpleStringProperty(prenom);
			this.nom = new SimpleStringProperty(nom);
			this.civilite = new SimpleStringProperty(civilite);
			this.fonction = new SimpleStringProperty (fonction);
			this.email= new SimpleStringProperty ( email);
			this.tel= new SimpleStringProperty (tel);
			
			this.identifiantR = new SimpleIntegerProperty(compteurR);
			this.tauxCommission = new SimpleFloatProperty (0);
			this.salaire = new SimpleFloatProperty (0);
			
			// Some initial dummy data, just for convenient testing.
			this.getAdresse().voie = new SimpleStringProperty("voie");
			this.getAdresse().cp = new SimpleIntegerProperty(1234);
			this.getAdresse().ville = new SimpleStringProperty("some city");
			this.getAdresse().bp = new SimpleStringProperty("1111");
			this.getAdresse().complement= new SimpleStringProperty("ccc");
			this.getAdresse().nomVoie= new SimpleStringProperty("tennis");
			this.getAdresse().num = new SimpleIntegerProperty(11);
			this.getAdresse().pays = new SimpleStringProperty("pays");
			
	

}

	
	
	
}
