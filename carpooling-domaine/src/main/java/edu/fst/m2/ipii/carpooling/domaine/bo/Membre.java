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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Membre")
public class Membre implements Serializable {
	public Membre() {
	}
	
	@Column(name="ID", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_MEMBRE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EDU_FST_M2_IPII_CARPOOLING_DOMAINE_BO_MEMBRE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="NomMembre", nullable=true, length=255)	
	private String nomMembre;
	
	@Column(name="PrenomMembre", nullable=true, length=255)	
	private String prenomMembre;
	
	@Column(name="Note", nullable=true)	
	private Float note;
	
	@Column(name="Login", nullable=true, length=255)	
	private String login;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;

	@Column(name="Email", nullable=true, length=255)
	private String email;
	
	@OneToMany(targetEntity=Voiture.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MembreID", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Voiture> voitures;
	
	@ManyToMany(targetEntity=Abonnement.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private Set<Abonnement> abonnements;
	
	@OneToMany(mappedBy="membre", targetEntity=Reservation.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Reservation> reservations;
	
	@OneToMany(targetEntity=Adresse.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MembreID", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Adresse> adresses;
	
	@OneToMany(targetEntity=PreferenceMembre.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MembreID", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<PreferenceMembre> preferenceMembres;
	
	@ManyToMany(targetEntity=Profil.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Membre_Profil", joinColumns={ @JoinColumn(name="MembreID") }, inverseJoinColumns={ @JoinColumn(name="ProfilID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private Set<Profil> profils;

	@OneToMany(targetEntity=Note.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="MembreID", nullable=false) })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private List<Note> notes;

	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLogin(String value) {
		this.login = value;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNomMembre(String value) {
		this.nomMembre = value;
	}
	
	public String getNomMembre() {
		return nomMembre;
	}
	
	public void setPrenomMembre(String value) {
		this.prenomMembre = value;
	}
	
	public String getPrenomMembre() {
		return prenomMembre;
	}
	
	public void setNote(float value) {
		setNote(new Float(value));
	}
	
	public void setNote(Float value) {
		this.note = value;
	}
	
	public Float getNote() {
		return note;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Voiture> getVoitures() {
        if (null == voitures) {
            voitures = new HashSet<>();
        }
		return voitures;
	}
	
	public Set<Abonnement> getAbonnements() {
        if (null == abonnements) {
            abonnements = new HashSet<>();
        }
		return abonnements;
	}
	
	public Set<Reservation> getReservations() {
        if (null == reservations) {
            reservations = new HashSet<>();
        }
		return reservations;
	}
	
	public Set<Adresse> getAdresses() {
        if (null == adresses) {
            adresses = new HashSet<>();
        }
		return adresses;
	}

	
	public Set<PreferenceMembre> getPreferenceMembres() {
        if (null == preferenceMembres) {
            preferenceMembres = new HashSet<>();
        }
		return preferenceMembres;
	}
	
	public Set<Profil> getProfils() {
        if (null == profils) {
            profils = new HashSet<>();
        }
		return profils;
	}

	public List<Note> getNotes() {
		if (null == notes) {
			notes = new ArrayList<>();
		}
		return notes;
	}

	public String toString() {
		return String.valueOf(getID());
	}
	
}
