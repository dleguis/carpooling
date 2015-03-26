/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Formule")
public class Formule implements Serializable {
	public Formule() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_FORMULE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_FORMULE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	@Column(name="Tarif", nullable=false, length=11)	
	private int tarif;
	
	@ManyToMany(targetEntity=Fonction.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Formule_Fonction", joinColumns={ @JoinColumn(name="FormuleID") }, inverseJoinColumns={ @JoinColumn(name="FonctionID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Fonction> fonctions;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTitre(String value) {
		this.titre = value;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTarif(int value) {
		this.tarif = value;
	}
	
	public int getTarif() {
		return tarif;
	}
	
	public Set<Fonction> getFonctions() {
        if (null == fonctions) {
            fonctions = new HashSet<>();
        }
		return fonctions;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
