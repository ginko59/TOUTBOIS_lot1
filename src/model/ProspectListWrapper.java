package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// définit le nom de l'élément racine.

@XmlRootElement(name = "prospects")
public class ProspectListWrapper {
	private List<Prospect> prospects;

	// est un nom optionel que nous pouvons spécifier pour l'élément.
	@XmlElement(name = "prospect")
	public List<Prospect> getProspects() {
		return prospects;
	}

	public void setProspects(List<Prospect> prospects) {
		this.prospects = prospects;
	}
}
