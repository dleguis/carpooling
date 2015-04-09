package edu.fst.m2.ipii.carpooling.transverse.dto;

/**
 * Created by Dimitri on 05/04/15.
 */
public class PointEmbarquementDto {

    private int ID;

    // private ReservationDto reservation;

    private Double latitude;

    private Double longitude;

    private String libelle;


    public int getID() {
        return this.ID;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
