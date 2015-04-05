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
@Table(name="Adresse")
public class Adresse implements Serializable {
	public Adresse() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_ADRESSE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_ADRESSE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Rue", nullable=true, length=255)	
	private String rue;
	
	@Column(name="Ville", nullable=true, length=255)	
	private String ville;
	
	@Column(name="CodePostal", nullable=true, length=255)	
	private String codePostal;
	
	@Column(name="Latitude", nullable=true)	
	private Double latitude;
	
	@Column(name="Longitude", nullable=true)	
	private Double longitude;
	
	@Column(name="Pays", nullable=true, length=255)	
	private String pays;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setRue(String value) {
		this.rue = value;
	}
	
	public String getRue() {
		return rue;
	}
	
	public void setVille(String value) {
		this.ville = value;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setCodePostal(String value) {
		this.codePostal = value;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setLatitude(double value) {
		setLatitude(new Double(value));
	}
	
	public void setLatitude(Double value) {
		this.latitude = value;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLongitude(double value) {
		setLongitude(new Double(value));
	}
	
	public void setLongitude(Double value) {
		this.longitude = value;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setPays(String value) {
		this.pays = value;
	}
	
	public String getPays() {
		return pays;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
