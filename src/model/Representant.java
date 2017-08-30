package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Representant extends Contact {
	public IntegerProperty identifiantR;
	public FloatProperty tauxCommission;
	public FloatProperty salaire;
	public Adresse adresse= new Adresse() ;
	
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
	public Representant() {
		super();
	}
	
	
	public Representant(String prenom, String nom, int identifiantC, String civilite, String fonction, String email, String tel, String enseigne, String siret) {
				
			this.enseigne = new SimpleStringProperty(enseigne); 
			this.siret = new SimpleStringProperty(siret);
			
											
			// Some initial dummy data, just for convenient testing.
			
			
			this.prenom = new SimpleStringProperty(prenom);
			this.nom = new SimpleStringProperty(nom);
			this.civilite = new SimpleStringProperty(civilite);
			this.fonction = new SimpleStringProperty (fonction);
			this.email= new SimpleStringProperty ( email);
			this.tel= new SimpleStringProperty (tel);
			
			this.identifiantR = new SimpleIntegerProperty(11);
			this.tauxCommission = new SimpleFloatProperty (0);
			this.salaire = new SimpleFloatProperty (0);
			
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
	public Adresse getAdresse() {
		return adresse;
	}	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
