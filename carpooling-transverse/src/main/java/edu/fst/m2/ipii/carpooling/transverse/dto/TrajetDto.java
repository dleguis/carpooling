package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;
import lombok.NonNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
@Getter
@Setter
public class TrajetDto {

    private int ID;

    private PointEmbarquementDto arrivee;

    private PointEmbarquementDto depart;

    private VoitureDto voiture;

    private String titre;

    private Date dateDepart;

    private int nbPlacesDisponibles;

    private double tarif;

    private String conducteur;

    private List<String> passagers;

    private Set<ReservationDto> reservations = new HashSet<>();

    private Set<CommentaireDto> commentaires = new HashSet<>();

}
