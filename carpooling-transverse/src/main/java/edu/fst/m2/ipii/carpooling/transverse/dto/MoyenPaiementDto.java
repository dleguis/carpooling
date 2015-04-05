package edu.fst.m2.ipii.carpooling.transverse.dto;

import lombok.*;

import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
public class MoyenPaiementDto {

    @Getter
    @Setter
    private int ID;

    @Getter
    @Setter
    private String libelle;

    @Getter
    @Setter
    private Set<PaiementDto> paiements;
}
