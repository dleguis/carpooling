package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Membre {
    private int id;
    private String nomMembre;
    private String prenomMembre;
    private Float note;
    private Collection<Abonnement> abonnements;
    private Collection<Commentaire> commentaires;
    private Adresse adresse;
    private Collection<Reservation> reservations;
    private Collection<Voiture> voitures;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NomMembre")
    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    @Basic
    @Column(name = "PrenomMembre")
    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    @Basic
    @Column(name = "Note")
    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Membre membre = (Membre) o;

        if (id != membre.id) return false;
        if (nomMembre != null ? !nomMembre.equals(membre.nomMembre) : membre.nomMembre != null) return false;
        if (note != null ? !note.equals(membre.note) : membre.note != null) return false;
        if (prenomMembre != null ? !prenomMembre.equals(membre.prenomMembre) : membre.prenomMembre != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomMembre != null ? nomMembre.hashCode() : 0);
        result = 31 * result + (prenomMembre != null ? prenomMembre.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "membre")
    public Collection<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(Collection<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    @OneToMany(mappedBy = "membre")
    public Collection<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @ManyToOne
    @JoinColumn(name = "AdresseID", referencedColumnName = "ID", nullable = false)
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @OneToMany(mappedBy = "membre")
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(mappedBy = "membre")
    public Collection<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(Collection<Voiture> voitures) {
        this.voitures = voitures;
    }
}
