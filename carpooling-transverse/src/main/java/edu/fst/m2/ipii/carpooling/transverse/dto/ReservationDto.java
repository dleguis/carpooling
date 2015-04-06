package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Date;

/**
 * Created by Dimitri on 02/04/15.
 */
@Getter
@Setter
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
}
