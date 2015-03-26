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
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Paiement")
public class Paiement implements Serializable {
	public Paiement() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_PAIEMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_PAIEMENT_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=MoyenPaiement.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MoyenPaiementID2", referencedColumnName="ID", nullable=false) })	
	private MoyenPaiement moyenPaiement;
	
	@Column(name="Somme", nullable=false)	
	private double somme;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setSomme(double value) {
		this.somme = value;
	}
	
	public double getSomme() {
		return somme;
	}
	
	public void setMoyenPaiement(MoyenPaiement value) {
		this.moyenPaiement = value;
	}
	
	public MoyenPaiement getMoyenPaiement() {
		return moyenPaiement;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
