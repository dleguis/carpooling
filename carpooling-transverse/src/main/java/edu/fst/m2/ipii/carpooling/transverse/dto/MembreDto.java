package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
@Getter
@Setter
public class MembreDto {

    private int ID;

    private String nomMembre;

    private String prenomMembre;

    private Float note;

    private String login;

    private String password;

    private List<VoitureDto> voitures = new ArrayList<>();

    private Set<AbonnementDto> abonnements = new HashSet<>();

    private Set<ReservationDto> reservations = new HashSet<>();

    private Set<AdresseDto> adresses = new HashSet<>();

    private Set<PreferenceMembreDto> preferenceMembres = new HashSet<>();

    private Set<ProfilDto> profils = new HashSet<>();

}
