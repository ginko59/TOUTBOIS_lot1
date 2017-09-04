package model;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pays {
	 private final IntegerProperty paysCode;
	 private final StringProperty pays;
	 
	 public Pays() {
		 this.paysCode = new SimpleIntegerProperty(1);
	     this.pays = new SimpleStringProperty("France");
	 }
	 
	 public Pays(int paysCode, String pays) {
	        this.paysCode = new SimpleIntegerProperty(paysCode);
	        this.pays = new SimpleStringProperty(pays);

	        
	 }
	 
	 public int getPaysCode() {
	        return paysCode.get();
	 }

	 public void setPaysCode(int paysCode) {
	        this.paysCode.set(paysCode);
	 }

	 public IntegerProperty paysCodeProperty() {
	        return paysCode;
	 }
	 
	 public String getPays() {
	        return pays.get();
	    }

	    public void setCountry(String pays) {
	        this.pays.set(pays);
	    }

	    public StringProperty paysProperty() {
	        return pays;
	    }
	    
	    @Override
		public String toString() {
			return this.getPaysCode() + " " + this.getPays();
		}
}
