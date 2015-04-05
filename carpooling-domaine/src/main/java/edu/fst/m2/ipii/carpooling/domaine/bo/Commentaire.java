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
@Table(name="Commentaire")
public class Commentaire implements Serializable {
	public Commentaire() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_COMMENTAIRE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_COMMENTAIRE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=edu.fst.m2.ipii.carpooling.domaine.bo.Membre.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MembreID", referencedColumnName="ID", nullable=false) })	
	private Membre membre;
	
	@Column(name="Contenu", nullable=true, length=255)	
	private String contenu;
	
	@Column(name="DateCommentaire", nullable=true)
	// @Temporal(TemporalType.DATE)
	private Date dateCommentaire;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setContenu(String value) {
		this.contenu = value;
	}
	
	public String getContenu() {
		return contenu;
	}
	
	public void setDateCommentaire(java.util.Date value) {
		this.dateCommentaire = value;
	}
	
	public java.util.Date getDateCommentaire() {
		return dateCommentaire;
	}
	
	public void setMembre(Membre value) {
		this.membre = value;
	}
	
	public Membre getMembre() {
		return membre;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
