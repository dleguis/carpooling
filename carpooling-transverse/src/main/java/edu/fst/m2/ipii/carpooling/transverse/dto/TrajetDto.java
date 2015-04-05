package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
public class TrajetDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private PointEmbarquementDto arrivee;

    @Getter
    @Setter
    private PointEmbarquementDto depart;

    @Getter
    @Setter
    private VoitureDto voiture;

    @Getter
    @Setter
    private String titre;

    @Getter
    @Setter
    private int nbPlacesDisponibles;

    @Getter
    @Setter
    private Set<ReservationDto> reservations;

    @Getter
    @Setter
    private Set<CommentaireDto> commentaires;


}
