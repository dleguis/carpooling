package edu.fst.m2.ipii.carpooling.transverse.dto;

import java.util.Date;

/**
 * Created by Dimitri on 02/04/15.
 */
public class ReservationDto {

    private int ID;

    private MembreDto membre;

    private FactureDto facture;

    // private TrajetDto trajet;

    private Date dateReservation;

    private int nombrePassagers;

    private boolean validee;

    private Float tarif;

    private boolean initiale;

    private PointEmbarquementDto pointEmbarquement;

    public int getID() {
        return this.ID;
    }

    public MembreDto getMembre() {
        return this.membre;
    }

    public FactureDto getFacture() {
        return this.facture;
    }

    public Date getDateReservation() {
        return this.dateReservation;
    }

    public int getNombrePassagers() {
        return this.nombrePassagers;
    }

    public boolean isValidee() {
        return this.validee;
    }

    public Float getTarif() {
        return this.tarif;
    }

    public boolean isInitiale() {
        return this.initiale;
    }

    public PointEmbarquementDto getPointEmbarquement() {
        return this.pointEmbarquement;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMembre(MembreDto membre) {
        this.membre = membre;
    }

    public void setFacture(FactureDto facture) {
        this.facture = facture;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setNombrePassagers(int nombrePassagers) {
        this.nombrePassagers = nombrePassagers;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public void setTarif(Float tarif) {
        this.tarif = tarif;
    }

    public void setInitiale(boolean initiale) {
        this.initiale = initiale;
    }

    public void setPointEmbarquement(PointEmbarquementDto pointEmbarquement) {
        this.pointEmbarquement = pointEmbarquement;
    }
}
