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
@Table(name="PointEmbarquement")
public class PointEmbarquement implements Serializable {
	public PointEmbarquement() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_POINTEMBARQUEMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_POINTEMBARQUEMENT_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@OneToOne(targetEntity=Reservation.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ReservationID", nullable=false) })	
	private Reservation reservation;
	
	@Column(name="Latitude", nullable=true)	
	private Float latitude;
	
	@Column(name="Longitude", nullable=true)	
	private Float longitude;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLatitude(float value) {
		setLatitude(new Float(value));
	}
	
	public void setLatitude(Float value) {
		this.latitude = value;
	}
	
	public Float getLatitude() {
		return latitude;
	}
	
	public void setLongitude(float value) {
		setLongitude(new Float(value));
	}
	
	public void setLongitude(Float value) {
		this.longitude = value;
	}
	
	public Float getLongitude() {
		return longitude;
	}
	
	public void setReservation(Reservation value) {
		this.reservation = value;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
