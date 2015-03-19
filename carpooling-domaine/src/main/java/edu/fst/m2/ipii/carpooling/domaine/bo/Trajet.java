package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Trajet {
    private int id;
    private String titre;
    private Collection<Commentaire> commentaires;
    private Collection<Reservation> reservations;
    private Voiture voiture;
    private Adresse adresseDepart;
    private Adresse adresseArrivee;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trajet trajet = (Trajet) o;

        if (id != trajet.id) return false;
        if (titre != null ? !titre.equals(trajet.titre) : trajet.titre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trajet")
    public Collection<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Collection<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @OneToMany(mappedBy = "trajet")
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    @ManyToOne
    @JoinColumn(name = "VoitureID", referencedColumnName = "ID", nullable = false)
    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    @ManyToOne
    @JoinColumn(name = "AdresseID2", referencedColumnName = "ID", nullable = false)
    public Adresse getAdresseDepart() {
        return adresseDepart;
    }

    public void setAdresseDepart(Adresse adresseDepart) {
        this.adresseDepart = adresseDepart;
    }

    @ManyToOne
    @JoinColumn(name = "AdresseID", referencedColumnName = "ID", nullable = false)
    public Adresse getAdresseArrivee() {
        return adresseArrivee;
    }

    public void setAdresseArrivee(Adresse adresseArrivee) {
        this.adresseArrivee = adresseArrivee;
    }
}
