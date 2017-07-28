package model;

public class Client extends Contact {

	public int identifiantC;
	public Representant representant ;
	
	//public int identifiantR;
	
	
	
	public int getIdentifiantC() {
		return identifiantC;
	}




	public int getIdentifiantR() {
		return getIdentifiantR();
	}




	public void setIdentifiantC(int identifiantC) {
		this.identifiantC = identifiantC;
	}


	public void setRepresentant(Representant representant) {
		this.representant = representant;
	}

	public Client(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
			String email, String tel, int nbCommande, Adresse adresse) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		// TODO Auto-generated constructor stub
	}


	public Client(String enseigne, String siret, String civilite, String nom, String prenom, String fonction,
			String email, String tel, int nbCommande, Adresse adresse, int identifiantC, Representant representant) {
		super(enseigne, siret, civilite, nom, prenom, fonction, email, tel, nbCommande, adresse);
		this.identifiantC = identifiantC;
		this.representant = representant;
	}


}
