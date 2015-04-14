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

import edu.fst.m2.ipii.carpooling.transverse.constants.Carburant;
import edu.fst.m2.ipii.carpooling.transverse.constants.CategorieEnum;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Voiture")
public class Voiture implements Serializable {
	public Voiture() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_VOITURE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_VOITURE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Marque", nullable=true, length=255)	
	private String marque;
	
	@Column(name="Modele", nullable=true, length=255)	
	private String modele;
	
	@Column(name="NbPlaces", nullable=false, length=11)	
	private int nbPlaces;
	
	@Column(name="Puissance", nullable=true)	
	private Float puissance;
	
	@Column(name="Carburant", nullable=true, length=255)
	@Enumerated(EnumType.STRING)
	private Carburant carburant;
	
	@Column(name="Categorie", nullable=true, length=255)
	@Enumerated(EnumType.STRING)
	private CategorieEnum categorie;

	@ManyToOne(targetEntity=Membre.class, fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name="MembreID", nullable=false) })
	private Membre proprietaire;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setMarque(String value) {
		this.marque = value;
	}
	
	public String getMarque() {
		return marque;
	}
	
	public void setModele(String value) {
		this.modele = value;
	}
	
	public String getModele() {
		return modele;
	}
	
	public void setNbPlaces(int value) {
		this.nbPlaces = value;
	}
	
	public int getNbPlaces() {
		return nbPlaces;
	}
	
	public void setPuissance(float value) {
		setPuissance(new Float(value));
	}
	
	public void setPuissance(Float value) {
		this.puissance = value;
	}
	
	public Float getPuissance() {
		return puissance;
	}
	
	public void setCarburant(Carburant value) {
		this.carburant = value;
	}
	
	public Carburant getCarburant() {
		return carburant;
	}
	
	public void setCategorie(CategorieEnum value) {
		this.categorie = value;
	}
	
	public CategorieEnum getCategorie() {
		return categorie;
	}


	public Membre getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Membre proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String toString() {
		return String.valueOf(getID());
	}
	
}
