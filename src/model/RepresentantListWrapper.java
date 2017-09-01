package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// d�finit le nom de l'�l�ment racine.

@XmlRootElement(name = "representants")
public class RepresentantListWrapper {
	private List<Representant> representants;
	
//est un nom optionel que nous pouvons sp�cifier pour l'�l�ment.
    @XmlElement(name = "representant")
    public List<Representant> getRepresentants() {
        return representants;
    }

    public void setRepresentants(List<Representant> representants) {
        this.representants = representants;
    }
}
