package model;

import javax.xml.bind.annotation.XmlTransient;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client extends Contact {
	private static int compteurC = 0; 

 final IntegerProperty identifiantC;
    protected final IntegerProperty identifiantR;
    
	

	public Client() {
		
			super();

			this.adresse = new Adresse();
			//this.representant = new Representant();
			
			compteurC ++;
			this.identifiantC =new SimpleIntegerProperty(compteurC);
			this.identifiantR  = new SimpleIntegerProperty(01);
			
			

		}
	
	public Integer getIdentifiantC() {
		return identifiantC.get();
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

	

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public int getIdentifiantR() {
        return identifiantR.get();
    }

    public void setIdentifiantR(int identifiantR) {
        this.identifiantR.set(identifiantR);
    }

    public IntegerProperty IdentifuantRProperty() {
        return identifiantR;
    }
	
	

	public Client(String prenom, String nom, String civilite, String fonction, String email, String tel, int nbCommande, String enseigne, String siret) {
	
		compteurC++;
		this.prenom = new SimpleStringProperty(prenom);
		this.nom = new SimpleStringProperty(nom);
		this.identifiantC = new SimpleIntegerProperty(compteurC);
		this.civilite = new SimpleStringProperty(civilite);
		this.fonction = new SimpleStringProperty (fonction);
		this.email= new SimpleStringProperty ( email);
		this.tel= new SimpleStringProperty (tel);
		this.nbCommande = new SimpleIntegerProperty(nbCommande);
		this.enseigne = new SimpleStringProperty(enseigne); 
		this.siret = new SimpleStringProperty(siret);
		this.identifiantR =new SimpleIntegerProperty(01);
		
		
		
		
		
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

	
	/*public void setIdentifiantC(IntegerProperty identifiantC) {
		this.identifiantC = identifiantC;
	}*/
	
	
	
}
