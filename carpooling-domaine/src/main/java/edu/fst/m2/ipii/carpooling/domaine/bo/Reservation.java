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

import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Reservation")
public class Reservation implements Serializable {
	public Reservation() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_RESERVATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_RESERVATION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=Membre.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MembreID2", referencedColumnName="ID", nullable=false) })	
	private Membre membre;
	
	@ManyToOne(targetEntity=Facture.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="FactureID", referencedColumnName="ID", nullable=false) })	
	private Facture facture;
	
	@ManyToOne(targetEntity=Trajet.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="TrajetID", referencedColumnName="ID", nullable=false) })	
	private Trajet trajet;
	
	@Column(name="DateReservation", nullable=true)	
	// @Temporal(TemporalType.DATE)
	private Date dateReservation;
	
	@Column(name="NombrePassagers", nullable=false, length=11)	
	private int nombrePassagers;
	
	@Column(name="Etat", nullable=false)
	@Enumerated(EnumType.STRING)
	private EtatReservation etat;
	
	@Column(name="Tarif", nullable=true)	
	private Float tarif;
	
	@Column(name="Initiale", nullable=false)
	private boolean initiale;
	
	@OneToOne(mappedBy="reservation", targetEntity=PointEmbarquement.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private PointEmbarquement pointEmbarquement;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDateReservation(Date value) {
		this.dateReservation = value;
	}
	
	public Date getDateReservation() {
		return dateReservation;
	}
	
	public void setNombrePassagers(int value) {
		this.nombrePassagers = value;
	}
	
	public int getNombrePassagers() {
		return nombrePassagers;
	}

	public EtatReservation getEtat() {
		return etat;
	}

	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}

	public void setTarif(float value) {
		setTarif(new Float(value));
	}
	
	public void setTarif(Float value) {
		this.tarif = value;
	}
	
	public Float getTarif() {
		return tarif;
	}
	
	public void setInitiale(boolean value) {
		this.initiale = value;
	}
	
	public boolean isInitiale() {
		return initiale;
	}
	
	public void setTrajet(Trajet value) {
		this.trajet = value;
	}
	
	public Trajet getTrajet() {
		return trajet;
	}
	
	public void setMembre(Membre value) {
		this.membre = value;
	}
	
	public Membre getMembre() {
		return membre;
	}
	
	public void setFacture(Facture value) {
		this.facture = value;
	}
	
	public Facture getFacture() {
		return facture;
	}
	
	public void setPointEmbarquement(PointEmbarquement value) {
		this.pointEmbarquement = value;
	}
	
	public PointEmbarquement getPointEmbarquement() {
		return pointEmbarquement;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
