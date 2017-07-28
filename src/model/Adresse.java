package model;

public class Adresse {
	public int num;
	public String voie;
	public String nomVoie;
	public String complement;
	public int bp;
	public int cp;
	public String ville;
	public String pays;
	public int getNum() {
		return num;
	}
	public String getVoie() {
		return voie;
	}
	public String getNomVoie() {
		return nomVoie;
	}
	public String getComplement() {
		return complement;
	}
	public int getBp() {
		return bp;
	}
	public int getCp() {
		return cp;
	}
	public String getVille() {
		return ville;
	}
	public String getPays() {
		return pays;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public void setBp(int bp) {
		this.bp = bp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	public Adresse(int num, String voie, String nomVoie, String complement, int bp, int cp, String ville, String pays) {
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
	
	
	

}
