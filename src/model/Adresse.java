package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adresse {
	public IntegerProperty num;
	public StringProperty voie;
	public StringProperty nomVoie;
	public StringProperty complement;
	public IntegerProperty bp;
	public IntegerProperty cp;
	public StringProperty ville;
	public StringProperty pays;
	
	public IntegerProperty getNum() {
		return num;
	}
	public String getVoie() {
		return voie.get();
	}
	public String getNomVoie() {
		return nomVoie.get();
	}
	public String getComplement() {
		return complement.get();
	}
	public IntegerProperty getBp() {
		return bp;
	}
	public IntegerProperty getCp() {
		return cp;
	}
	public String getVille() {
		return ville.get();
	}
	public String getPays() {
		return pays.get();
	}
	public void setNum(IntegerProperty num) {
		this.num = num;
	}
	public void setVoie(StringProperty voie) {
		this.voie = voie;
	}
	public void setNomVoie(StringProperty nomVoie) {
		this.nomVoie = nomVoie;
	}
	public void setComplement(StringProperty complement) {
		this.complement = complement;
	}
	public void setBp(IntegerProperty bp) {
		this.bp = bp;
	}
	public void setCp(IntegerProperty cp) {
		this.cp = cp;
	}
	public void setVille(String ville) {
		this.ville.set(ville);
	}
	public void setPays(String pays) {
		this.pays.set(pays);
	}
	
	
	
	public Adresse(IntegerProperty num, StringProperty voie, StringProperty nomVoie, StringProperty complement, IntegerProperty bp, IntegerProperty cp, StringProperty ville, StringProperty pays) {
		super();
		this.num = num;
		this.voie = voie;
		this.nomVoie = nomVoie;
		this.complement = complement;
		this.bp = bp;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}
	
	public Adresse() {
		super();
		
	}
	
	
	
	
	

}
