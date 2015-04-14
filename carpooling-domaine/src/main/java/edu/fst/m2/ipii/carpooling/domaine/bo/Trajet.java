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
import java.util.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Trajet")
public class Trajet implements Serializable {
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_TRAJET_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_TRAJET_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=PointEmbarquement.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	// @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="PointEmbarquementID", referencedColumnName="ID", nullable=false) })	
	private PointEmbarquement arrivee;

	@Transient
	private PointEmbarquement depart;
	
	@ManyToOne(targetEntity=Voiture.class, fetch=FetchType.LAZY)	
	@JoinColumns({ @JoinColumn(name="VoitureID", referencedColumnName="ID", nullable=false) })
	private Voiture voiture;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;

	@Column(name="DateDepart", nullable=true)
	// @Temporal(TemporalType.DATE)
	private Date dateDepart;

	@Column(name = "actif")
	private boolean actif;
	
	@OneToMany(mappedBy="trajet", targetEntity=Reservation.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private List<Reservation> reservations;
	
	@OneToMany(targetEntity=Commentaire.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="TrajetID", nullable=false) })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Commentaire> commentaires;

	@Transient
	private int nbPlacesDisponibles;

	@Transient
	private double tarif;

	@Transient
	private String conducteur;

	@Transient
	private List<String> passagers = new ArrayList<>();

	@Transient
	private List<Membre> membresPassagers = new ArrayList<>();

	@PostLoad
	public void buildTransientValues() {

		int placesDisponibles = null == voiture ? 0 : voiture.getNbPlaces();

		for (Reservation reservation : getReservations()) {

			if (reservation.getEtat() == EtatReservation.INITIALE) {
				tarif = reservation.getTarif();
				conducteur = reservation.getMembre().getLogin();
			}
			if (reservation.getEtat() == EtatReservation.INITIALE || reservation.getEtat() == EtatReservation.VALIDEE) {
				passagers.add(reservation.getMembre().getLogin());
				membresPassagers.add(reservation.getMembre());
				placesDisponibles -= reservation.getNombrePassagers();
			}
		}

		nbPlacesDisponibles = placesDisponibles;

	}
	
	private void setID(int value) {
		this.ID = value;
	}

	public double getTarif() {

		return tarif;
	}

	public int getNbPlacesDisponibles() {

		return nbPlacesDisponibles;
	}

	public String getConducteur() {
		return conducteur;
	}

	public List<String> getPassagers() {
		return passagers;
	}

	public List<Membre> getMembresPassagers() {
		return membresPassagers;
	}

	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTitre(String value) {
		this.titre = value;
	}
	
	public String getTitre() {
		return titre;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public List<Reservation> getReservations() {
        if (null == reservations) {
            reservations = new ArrayList<>();
        }
		return reservations;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public void setVoiture(Voiture value) {
		this.voiture = value;
	}
	
	public Voiture getVoiture() {
		return voiture;
	}

	
	public Set<Commentaire> getCommentaires() {
        if (null == commentaires) {
            commentaires = new HashSet<>();
        }
		return commentaires;
	}

	public PointEmbarquement getDepart() {
		for (Reservation reservation : getReservations()) {
			if (reservation.isInitiale()) {
				depart = reservation.getPointEmbarquement();
				break;
			}
		}
		return depart;
	}

	public void setArrivee(PointEmbarquement value) {
		this.arrivee = value;
	}
	
	public PointEmbarquement getArrivee() {
		return arrivee;
	}

	public String toString() {
		return String.valueOf(getID());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Trajet)) return false;

		Trajet trajet = (Trajet) o;

		if (ID != trajet.ID) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return ID;
	}
}
