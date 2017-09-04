package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of pays. This is used for saving the
 * list of pays to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "listpays")

public class PaysListWrapper {
	private List<Pays> listpays;

    @XmlElement(name = "pays")
    public List<Pays> getListPays() {
        return listpays;
    }

    public void setListPays(List<Pays> listpays) {
        this.listpays = listpays;
    }
}
