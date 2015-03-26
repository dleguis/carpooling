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
@Table(name="PreferenceMembre")
public class PreferenceMembre implements Serializable {
	public PreferenceMembre() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_PREFERENCEMEMBRE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_PREFERENCEMEMBRE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Cle", nullable=true, length=255)	
	private String cle;
	
	@Column(name="Valeur", nullable=true, length=255)	
	private String valeur;
	
	@Column(name="Libelle", nullable=true, length=255)	
	private String libelle;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCle(String value) {
		this.cle = value;
	}
	
	public String getCle() {
		return cle;
	}
	
	public void setValeur(String value) {
		this.valeur = value;
	}
	
	public String getValeur() {
		return valeur;
	}
	
	public void setLibelle(String value) {
		this.libelle = value;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
