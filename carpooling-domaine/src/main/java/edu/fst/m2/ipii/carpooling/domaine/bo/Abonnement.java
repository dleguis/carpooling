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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Abonnement")
public class Abonnement implements Serializable {
	public Abonnement() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_ABONNEMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_ABONNEMENT_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Libelle", nullable=true, length=255)	
	private String libelle;
	
	@Column(name="DateDebutValide", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private Date dateDebutValide;
	
	@Column(name="DateFinValide", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private Date dateFinValide;
	
	@ManyToMany(targetEntity=edu.fst.m2.ipii.carpooling.domaine.bo.Formule.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Abonnement_Formule", joinColumns={ @JoinColumn(name="AbonnementID") }, inverseJoinColumns={ @JoinColumn(name="FormuleID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Formule> formules;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLibelle(String value) {
		this.libelle = value;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setDateDebutValide(java.util.Date value) {
		this.dateDebutValide = value;
	}
	
	public java.util.Date getDateDebutValide() {
		return dateDebutValide;
	}
	
	public void setDateFinValide(java.util.Date value) {
		this.dateFinValide = value;
	}
	
	public java.util.Date getDateFinValide() {
		return dateFinValide;
	}

	
	public Set<Formule> getFormules() {
        if (null == formules) {
            formules = new HashSet<>();
        }
		return formules;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
