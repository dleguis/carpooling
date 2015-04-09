package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 09/04/15.
 */
public class NouvelleReservationDto {

    private int trajetId;
    private String pointEmbarquement;
    private int membreId;
    int nbPlaces;
    int moyenPaiementId;

    public int getTrajetId() {
        return trajetId;
    }

    public void setTrajetId(int trajetId) {
        this.trajetId = trajetId;
    }

    public String getPointEmbarquement() {
        return pointEmbarquement;
    }

    public void setPointEmbarquement(String pointEmbarquement) {
        this.pointEmbarquement = pointEmbarquement;
    }

    public int getMembreId() {
        return membreId;
    }

    public void setMembreId(int membreId) {
        this.membreId = membreId;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getMoyenPaiementId() {
        return moyenPaiementId;
    }

    public void setMoyenPaiementId(int moyenPaiementId) {
        this.moyenPaiementId = moyenPaiementId;
    }
}
