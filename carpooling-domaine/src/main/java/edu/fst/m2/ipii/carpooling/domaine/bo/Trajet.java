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
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Trajet")
public class Trajet implements Serializable {
	public Trajet() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_TRAJET_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_TRAJET_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=PointEmbarquement.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="PointEmbarquementID", referencedColumnName="ID", nullable=false) })	
	private PointEmbarquement arrivee;
	
	@ManyToOne(targetEntity=Voiture.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="VoitureID", referencedColumnName="ID", nullable=false) })	
	private Voiture voiture;
	
	@Column(name="Titre", nullable=true, length=255)	
	private String titre;
	
	@OneToMany(mappedBy="trajet", targetEntity=Reservation.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	@OneToMany(targetEntity=Commentaire.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="TrajetID", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Commentaire> commentaires = new HashSet<Commentaire>();
	
	private void setID(int value) {
		this.ID = value;
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

	public Set<Reservation> getReservations() {
        if (null == reservations) {
            reservations = new HashSet<>();
        }
		return reservations;
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
	
	
	public void setArrivee(PointEmbarquement value) {
		this.arrivee = value;
	}
	
	public PointEmbarquement getArrivee() {
		return arrivee;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
