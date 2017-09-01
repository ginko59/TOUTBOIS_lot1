package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// définit le nom de l'élément racine.

@XmlRootElement(name = "representants")
public class RepresentantListWrapper {
	private List<Representant> representants;
	
//est un nom optionel que nous pouvons spécifier pour l'élément.
    @XmlElement(name = "representant")
    public List<Representant> getRepresentants() {
        return representants;
    }

    public void setRepresentants(List<Representant> representants) {
        this.representants = representants;
    }
}
