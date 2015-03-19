package edu.fst.m2.ipii.carpooling.domaine.bo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Dimitri on 20/03/2015.
 */
@Entity
public class Reservation {
    private int id;
    private Date dateReservation;
    private int nombrePassagers;
    private boolean validee;
    private Float tarif;
    private boolean initiale;
    private Collection<PointEmbarquement> pointsEmbarquement;
    private Membre membre;
    private Trajet trajet;
    private Facture facture;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DateReservation")
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "NombrePassagers")
    public int getNombrePassagers() {
        return nombrePassagers;
    }

    public void setNombrePassagers(int nombrePassagers) {
        this.nombrePassagers = nombrePassagers;
    }

    @Basic
    @Column(name = "Validee")
    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    @Basic
    @Column(name = "Tarif")
    public Float getTarif() {
        return tarif;
    }

    public void setTarif(Float tarif) {
        this.tarif = tarif;
    }

    @Basic
    @Column(name = "Initiale")
    public boolean isInitiale() {
        return initiale;
    }

    public void setInitiale(boolean initiale) {
        this.initiale = initiale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (initiale != that.initiale) return false;
        if (nombrePassagers != that.nombrePassagers) return false;
        if (validee != that.validee) return false;
        if (dateReservation != null ? !dateReservation.equals(that.dateReservation) : that.dateReservation != null)
            return false;
        if (tarif != null ? !tarif.equals(that.tarif) : that.tarif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateReservation != null ? dateReservation.hashCode() : 0);
        result = 31 * result + nombrePassagers;
        result = 31 * result + (validee ? 1 : 0);
        result = 31 * result + (tarif != null ? tarif.hashCode() : 0);
        result = 31 * result + (initiale ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "reservation")
    public Collection<PointEmbarquement> getPointsEmbarquement() {
        return pointsEmbarquement;
    }

    public void setPointsEmbarquement(Collection<PointEmbarquement> pointsEmbarquement) {
        this.pointsEmbarquement = pointsEmbarquement;
    }

    @ManyToOne
    @JoinColumn(name = "MembreID2", referencedColumnName = "ID", nullable = false)
    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    @ManyToOne
    @JoinColumn(name = "TrajetID", referencedColumnName = "ID", nullable = false)
    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    @ManyToOne
    @JoinColumn(name = "FactureID", referencedColumnName = "ID", nullable = false)
    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
