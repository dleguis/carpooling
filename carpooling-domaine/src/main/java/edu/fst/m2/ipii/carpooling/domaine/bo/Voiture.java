package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Voiture {
    private int id;
    private String marque;
    private String modele;
    private int nbPlaces;
    private Float puissance;
    private String carburant;
    private String categorie;
    private Collection<Trajet> trajets;
    private Membre membre;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "Modele")
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "NbPlaces")
    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    @Basic
    @Column(name = "Puissance")
    public Float getPuissance() {
        return puissance;
    }

    public void setPuissance(Float puissance) {
        this.puissance = puissance;
    }

    @Basic
    @Column(name = "Carburant")
    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    @Basic
    @Column(name = "Categorie")
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voiture voiture = (Voiture) o;

        if (id != voiture.id) return false;
        if (nbPlaces != voiture.nbPlaces) return false;
        if (carburant != null ? !carburant.equals(voiture.carburant) : voiture.carburant != null) return false;
        if (categorie != null ? !categorie.equals(voiture.categorie) : voiture.categorie != null) return false;
        if (marque != null ? !marque.equals(voiture.marque) : voiture.marque != null) return false;
        if (modele != null ? !modele.equals(voiture.modele) : voiture.modele != null) return false;
        if (puissance != null ? !puissance.equals(voiture.puissance) : voiture.puissance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (modele != null ? modele.hashCode() : 0);
        result = 31 * result + nbPlaces;
        result = 31 * result + (puissance != null ? puissance.hashCode() : 0);
        result = 31 * result + (carburant != null ? carburant.hashCode() : 0);
        result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "voiture")
    public Collection<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(Collection<Trajet> trajets) {
        this.trajets = trajets;
    }

    @ManyToOne
    @JoinColumn(name = "MembreID", referencedColumnName = "ID", nullable = false)
    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
