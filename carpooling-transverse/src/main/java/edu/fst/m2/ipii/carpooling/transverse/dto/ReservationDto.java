package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by Dimitri on 02/04/15.
 */
public class ReservationDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private MembreDto membre;

    @Getter
    @Setter
    private FactureDto facture;

    @Getter
    // @Setter
    private TrajetDto trajet;

    @Getter
    @Setter
    private Date dateReservation;

    @Getter
    @Setter
    private int nombrePassagers;

    @Getter
    @Setter
    private boolean validee;

    @Getter
    @Setter
    private Float tarif;

    @Getter
    @Setter
    private boolean initiale;

    @Getter
    @Setter
    private PointEmbarquementDto pointEmbarquement;
}
