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

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Facture")
public class Facture implements Serializable {
	public Facture() {
	}
	
	@Column(name="ID", nullable=false, length=11)
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_FACTURE_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_FACTURE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=Paiement.class, fetch= FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="PaiementID", referencedColumnName="ID", nullable=false) })
	private Paiement paiement;
	
	@Column(name="`Date`", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private Date date;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDate(Date value) {
		this.date = value;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setPaiement(Paiement value) {
		this.paiement = value;
	}
	
	public Paiement getPaiement() {
		return paiement;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
