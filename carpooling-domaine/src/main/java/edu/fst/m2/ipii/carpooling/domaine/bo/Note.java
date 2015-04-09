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
@Table(name="Note")
public class Note implements Serializable {
	public Note() {
	}
	
	@Column(name="ID", nullable=false, length=255)	
	@Id	
	private String ID;

	@Column(name = "Note", nullable = false)
	private int note;

	@ManyToOne(targetEntity=Membre.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	// @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="NoteurID", referencedColumnName="ID", nullable=false) })
	private Membre noteur;
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Membre getNoteur() {
		return noteur;
	}

	public void setNoteur(Membre noteur) {
		this.noteur = noteur;
	}

	public String getORMID() {
		return getID();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
}
