package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Set;

/**
 * Created by Dimitri on 02/04/15.
 */
public class MembreDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private String nomMembre;
    
    @Getter
    @Setter
    private String prenomMembre;

    @Getter
    @Setter
    private Float note;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;
    
    @Getter
    @Setter
    private Set<VoitureDto> voitures;
    
    @Getter
    @Setter
    private Set<AbonnementDto> abonnements;
    
    @Getter
    @Setter
    private Set<ReservationDto> reservations;
    
    @Getter
    @Setter
    private Set<AdresseDto> adresses;
    
    @Getter
    @Setter
    private Set<PreferenceMembreDto> preferenceMembres;
    
    @Getter
    @Setter
    private Set<ProfilDto> profils;

}
