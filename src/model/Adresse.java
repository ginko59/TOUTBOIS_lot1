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
	
	public Integer getNum() {
		return num.get();
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
	public Integer getBp() {
		return bp.get();
	}
	public Integer getCp() {
		return cp.get();
	}
	public String getVille() {
		return ville.get();
	}
	public String getPays() {
		return pays.get();
	}
	public void setNum(Integer num) {
		this.num.set(num);
	}
	public void setVoie(String voie) {
		this.voie.set(voie);
	}
	public void setNomVoie(String nomVoie) {
		this.nomVoie.set(nomVoie);
	}
	public void setComplement(String complement) {
		this.complement.set(complement);
	}
	public void setBp(Integer bp) {
		this.bp.set(bp);
	}
	public void setCp(Integer cp) {
		this.cp.set(cp);
	}
	public void setVille(String ville) {
		this.ville.set(ville);
	}
	public void setPays(String pays) {
		this.pays.set(pays);
	}
	
	public IntegerProperty numProperty() {
		return num;
	}
	public StringProperty voieProperty() {
		return voie;
	}
	public StringProperty nomVoieProperty() {
		return nomVoie ;
	}
	public StringProperty complementProperty() {
		return complement ;
	}
	public IntegerProperty bpProperty() {
		return bp;
	}
	public IntegerProperty cpProperty () {
		return cp;
	}
	public StringProperty villeProperty() {
		return ville;
	}
	public StringProperty paysProperty() {
		return pays ;
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
