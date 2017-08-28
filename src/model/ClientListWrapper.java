package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// d�finit le nom de l'�l�ment racine.

@XmlRootElement(name = "clients")
public class ClientListWrapper {
	private List<Client> clients;
	
//est un nom optionel que nous pouvons sp�cifier pour l'�l�ment.
    @XmlElement(name = "client")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
